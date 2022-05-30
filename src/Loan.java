public final class Loan {
    
    public Loan(double mablagh_vam, int tedad_mah, double nerkh_bahreh) {
        this.setmablagh_vam(mablagh_vam);
        this.setzaman(tedad_mah);
        this.setsood_salaneh(nerkh_bahreh);
    }
    
    // mablagh vam
    private double vam;
    public double getmablagh_vam() {
        return vam;
    }
    public void setmablagh_vam(double vam) {
        this.vam = Math.max(vam, 0);
    }
    
    // zaman
    private int zaman;
    public int getzaman() {
        return zaman;
    }
    public void setzaman(int zaman) {
        this.zaman = Math.max(zaman, 1);
    }

    // nerkh
    private double nerkh_salaneh;
    public double getnerkh_salaneh() {
        return nerkh_salaneh;
    }
    public void setsood_salaneh(double nerkh_salaneh) {
        this.nerkh_salaneh = Math.max(nerkh_salaneh, 0);
    }

    // sood mahaneh
    public double sood_mahaneh() {
        return this.getnerkh_salaneh()/12;
    }
    
    // pardakht mahaneh
    public double pardakht_mahaneh() {
        double P = this.getmablagh_vam();
        double J = this.sood_mahaneh()/100;
        int n = this.getzaman();
        double M = P*J/(1-Math.pow(1+J,-n));
        return M;
    }
    
    // pardakht kol
    public double pardakht_kol() {
        double M = this.pardakht_mahaneh();
        int n = this.getzaman();
        return n*M;
    }
    
    // kol bahreh
    public double getkol_sood() {
        return this.pardakht_kol()-this.getmablagh_vam();
    }
    
    // sood mahaneh
    public double sood_mahanneh() {
        return this.getkol_sood()/this.getzaman();
    }

    // sood salaneh
    public double sood_salaneh() {
        return 12*this.sood_mahanneh();
    }
    
}
