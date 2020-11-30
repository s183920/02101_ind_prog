public class Complex {
    private double im;
    private double re;

    public Complex(){
        this.re = 0;
        this.im = 0;
    }
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public Complex(Complex z) {
        this.re = z.getRe();
        this.im = z.getIm();
    }
    public double getRe(){
        return this.re;
    }
    public double getIm(){
        return this.im;
    }
    public double abs() {
        return Math.sqrt(this.re*this.re + this.im*this.im);
    }
    public Complex plus(Complex other){
        return new Complex(this.re + other.re, this.im + other.im);
    }
    public Complex times(Complex other){
        return new Complex(this.re*other.re - this.im*other.im, this.im*other.re +this.re*other.im);
    }
    public String toString(){
        return this.im >= 0 ? this.re +" + " + this.im + "i" : this.re +" " + this.im + "i";
    }

}
