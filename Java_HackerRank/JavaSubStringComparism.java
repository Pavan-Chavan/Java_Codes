/* Title: Java sub string compararisn
coder:Pavan Chavan
date: 29/8/21 */

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        int start = 0, end = k;
        smallest = s.substring(start, end);

        for (; end <=s.length(); end++, start++) {
            if (s.substring(start, end).compareTo(smallest) < 0) {
                smallest = s.substring(start, end);
            }
            if (s.substring(start, end).compareTo(largest) > 0) {
                largest = s.substring(start, end);

            }
        }

        return smallest + "\n" + largest;
    }
