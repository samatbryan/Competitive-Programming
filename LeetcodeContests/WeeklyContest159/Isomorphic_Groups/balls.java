public class balls {
  int x;

  balls(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    balls b = new balls(1);
    balls c = new balls(2);
    balls d = b;
    balls b = c;
  }
}
