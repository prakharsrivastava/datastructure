public class LicenseKeyFormatter {

    public static String licenseKeyFormatting(String S, int K) {
        char[] arr = S.toUpperCase().toCharArray();
        int n = arr.length;
        int write = n - 1;

        // Step 1: Move all alphanumeric characters to the end of the array
        for (int read = n - 1; read >= 0; read--) {
            if (arr[read] != '-') {
                arr[write--] = arr[read];
            }
        }

        int totalChars = n - 1 - write;
        int totalDashes = (totalChars - 1) / K;
        int finalLength = totalChars + totalDashes;

        // Step 2: Fill from the end, adding dashes appropriately
        int index = finalLength - 1;
        int count = 0;

        for (int i = n - 1; i > write; i--) {
            if (count == K) {
                arr[index--] = '-';
                count = 0;
            }
            arr[index--] = arr[i];
            count++;
        }

        return new String(arr, index + 1, finalLength);
    }

    public static void main(String[] args) {
        String S1 = "5F3Z-2e-9-w";
        int K1 = 4;
        System.out.println(licenseKeyFormatting(S1, K1));  // Output: "5F3Z-2E9W"

        String S2 = "2-5g-3-J";
        int K2 = 2;
        System.out.println(licenseKeyFormatting(S2, K2));  // Output: "2-5G-3J"
    }
}
