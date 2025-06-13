import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static List<int[]> microInsertionList;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static Set<int[]> microList;
    static class MicroInfo {
        int index, size;
        Set<Integer> adjacentSet;
        public MicroInfo(int index, int size, Set<Integer> adjacentSet) {
            this.index = index;
            this.size = size;
            this.adjacentSet = adjacentSet;
        }
    }

    public static void main(String[] args) throws IOException {
        // 좌측 하단이 0,0, 가장 우측 상단이 N,N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        microInsertionList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            microInsertionList.add(new int[]{startR, startC, endR, endC});
        }

        // Q번의 실험
        for (int i = 1; i <= q; i++) {
            int[] coords = microInsertionList.get(i - 1);
            // 미생물 투입
            insertMicro(coords, i);
            // 배양 용기 이동
            moveMicro();
            // 실험 결과 기록
            recordResult();
        }
    }

    static void insertMicro(int[] coords, int index) {
        int[][] newMap = map;
        // (sr, sc)부터 (er, ec)까지 index로 채움
        int sr = coords[0]; int sc = coords[1];
        int er = coords[2]; int ec = coords[3];
        for (int i = sc; i < ec; i++) {
            for (int j = sr; j < er; j++) {
                newMap[i][j] = index;
            }
        }

//        System.out.println("투입: ");
//        for(int[] row : map) {
//            for (int micro : row) {
//                System.out.print(micro + " ");
//            }
//            System.out.println();
//        }

        // 기존의 미생물이 두 영역으로 나눠지면 모두 사라짐
        Map<Integer, Integer> microMap = new HashMap<>(); // (인덱스, 해당 인덱스 영역의 개수)
        microList = new TreeSet<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]); // 영역의 크기가 큰 순으로 뽑기
            } else {
                return Integer.compare(a[0], b[0]); // 그렇지 않으면 인덱스가 빠른 것부터 뽑기
            }
        });
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newMap[i][j] != 0) {
                    if (visited[i][j]) continue;
                    MicroInfo info = bfs(i, j, newMap); // [인덱스, 영역의 크기]
                    if (info.index == newMap[i][j]) {
                        microMap.put(info.index, microMap.getOrDefault(info.index, 0) + 1);
                        if (microMap.get(info.index) > 1) {
                            newMap = removeMicro(newMap, info.index);
                            continue;
                        }
                    }
                    microList.add(new int[]{info.index, info.size}); // 배양 용기 이동 시에 사용
                }
            }
        }

//        System.out.println("다음 미생물 뽑는 순서: ");
//        for (int[] micro : microList) {
//            System.out.println(micro[0] + " " + micro[1]);
//        }
//
//        System.out.println("처리 완료: ");
//        for(int[] row : newMap) {
//            for (int micro : row) {
//                System.out.print(micro + " ");
//            }
//            System.out.println();
//        }

        map = newMap;
    }

    static void moveMicro() {
        int[][] newMap = new int[n][n];

        for (int[] info : microList) {
            int id = info[0];
            List<int[]> shape = findOriginalPos(id);

            int h = 0, w = 0;
            for (int[] p : shape) {
                h = Math.max(h, p[0]);
                w = Math.max(w, p[1]);
            }

            boolean placed = false;
            for (int c = 0; c + w < n && !placed; c++) {
                for (int r = 0; r + h < n; r++) {
                    boolean ok = true;
                    for (int[] p : shape) {
                        int nr = r + p[0];
                        int nc = c + p[1];
                        if (newMap[nr][nc] != 0) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;

                    for (int[] p : shape) {
                        newMap[r + p[0]][c + p[1]] = id;
                    }
                    placed = true;
                    break;
                }
            }
        }

//        System.out.println("이동 완료: ");
//        for(int[] row : newMap) {
//            for (int micro : row) {
//                System.out.print(micro + " ");
//            }
//            System.out.println();
//        }

        map = newMap;      // 새 용기로 교체
        microList.clear(); // 다음 실험을 위해 초기화
    }

    static void recordResult() {
        visited = new boolean[n][n];

        List<MicroInfo> infos = new ArrayList<>();
        Set<String> pairSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    MicroInfo info = bfs(i, j, map);
                    infos.add(info);
                }
            }
        }

        for (MicroInfo info : infos) {
            int a = info.index;
            for (int b : info.adjacentSet) {
                if (b == 0 || a == b) continue;
                int u = Math.min(a, b);
                int v = Math.max(a, b);
                pairSet.add(u + "," + v);
            }
        }

        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (MicroInfo info : infos) {
            sizeMap.put(info.index, info.size);
        }

        int result = 0;
        for (String pair : pairSet) {
            String[] parts = pair.split(",");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            result += sizeMap.get(a) * sizeMap.get(b);
        }
        System.out.println(result);
    }

    static MicroInfo bfs(int r, int c, int[][] map) {
        Queue<int[]> queue  = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int index = map[r][c]; // 탐색한 인덱스
        int size = 1; // 영역의 크기
        Set<Integer> adSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] != map[r][c]) {
                    adSet.add(map[nr][nc]);
                }
                if (map[nr][nc] == map[r][c]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    size++;
                }
            }
        }

        return new MicroInfo(index, size, adSet);
    }

    static int[][] removeMicro(int[][] map, int target) {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == target) map[i][j] = 0;
            }
        }
        newMap = map;
        return newMap;
    }

    static List<int[]> findOriginalPos(int id) {
        List<int[]> abs = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] localVisited = new boolean[n][n];

        // 덩어리의 첫 칸 찾기
        outer:
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == id) {
                    q.add(new int[]{r, c});
                    localVisited[r][c] = true;
                    break outer;
                }
            }
        }

        int minR = n, minC = n;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            abs.add(cur);
            minR = Math.min(minR, cur[0]);
            minC = Math.min(minC, cur[1]);

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dx[d];
                int nc = cur[1] + dy[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (!localVisited[nr][nc] && map[nr][nc] == id) {
                    localVisited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        // 상대 좌표로 변환
        List<int[]> rel = new ArrayList<>(abs.size());
        for (int[] p : abs) rel.add(new int[]{p[0] - minR, p[1] - minC});
        return rel; // (0,0)이 항상 포함
    }

}