public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input_obj = new SafeInputObj();

        // Test Get NZL Str
        String test_string = input_obj.getNonZeroLenString("Write anything");
        System.out.println(test_string);

        // Test Get Ranged Int
        int ranged_int = input_obj.getRangedInt("Give me an int value between 1 and 2", 1, 2);
        System.out.println(ranged_int);

        // Test Get Ranged Double
        double ranged_double = input_obj.getRangedDouble("Give me a double value between 1.0 and 1.9", 1, 1.9);
        System.out.println(ranged_double);

        // Test Get YN Confirm
        boolean yn_confirm = input_obj.getYNConfirm("Type [Y] and I return True, [N] for False");
        System.out.println(yn_confirm);

        // Test Get Int
        int int_val = input_obj.getInt("Type any whole number");
        System.out.println(int_val);

        // Test Get Double
        double double_val = input_obj.getDouble("Type any decimal number");
        System.out.println(double_val);
    }
}
