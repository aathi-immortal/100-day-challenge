import java.util.Scanner;

class ComplexNumber {
    public float real;
    public float imaginary;

    ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        
    }

    public ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(this.real + x.real, this.imaginary + x.imaginary);

    }

    public ComplexNumber subtract(ComplexNumber x) {
        return new ComplexNumber(this.real - x.real, this.imaginary - x.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber x) {
        return new ComplexNumber((this.real * x.real) + (this.imaginary * x.imaginary * -1),
                (this.real * x.imaginary) + (this.imaginary * x.real));
    }

    public ComplexNumber divide(ComplexNumber x) {
        float denominator = x.real * x.real + x.imaginary * x.imaginary;
        float realResult = (this.real * x.real + this.imaginary * x.imaginary) / denominator;
        float imaginaryResult = (this.imaginary * x.real - this.real * x.imaginary) / denominator;
        return new ComplexNumber(realResult, imaginaryResult);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplexNumber complexNumber = new ComplexNumber(23, 21);
    }
}
