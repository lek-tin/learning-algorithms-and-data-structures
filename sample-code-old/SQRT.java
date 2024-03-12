class SQRT {

  /**
    Binary search
   */
  public static calcInt(int x) {
    if (x < 2) return 2;
 
    long try_;
    int pivot, lo = 2, hi = x / 2;

    while (lo <= hi) {
        pivot = lo + (hi - lo) / 2;
        try_ = (long) pivot * pivot;
        if (try_ < x) {
            lo = pivot + 1;
        } else if (try_ > x) {
            hi = pivot - 1;
        } else {
            return pivot;
        }
    }

    return hi;
  }
  /**
    Newton's method
   */
  public static calcDouble(int x) {
    double res = x;
    
    // y_n+1 - y_n = y_n'(x_n+1 - x_n)
    // solve for y_n+1 = 0
    // x_n+1 = x_n - y_n'/y_n
    // x_n+1 = 0.5 * (x_n + x / x_n)
    while (Math.abs(res*res - x) > 1e-6) {
      res = 0.5 * (res + x / res);
    }
    
    return res;
  }
}
