package learning;

public class temp {
    public static void main(String[] args) {

        String text = "Please email us at mentor@rahulshettyacademy.com with below template to receive response";
        String[] parts = text.split("at ");
        System.out.println(parts[0]);
    }
}
