/**
 * Created by junle
 */
public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;

    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public double calcForceExertedBy(Planet p){
        return G*p.mass*this.mass/(calcDistance(p)*calcDistance(p));
    }
    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        return F*dx/r;
    }
    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        return F*dy/r;
    }
    public double calcNetForceExertedByX(Planet[] planets){
        double Fx = 0;
        for (Planet p : planets){
            if (!p.equals(this))
                Fx += calcForceExertedByX(p);
        }
        return Fx;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        double Fy = 0;
        for (Planet p : planets){
            if (!p.equals(this))
                Fy += calcForceExertedByY(p);
        }
        return Fy;
    }
    public void update(double dt,double fx,double fy){
        double ax = fx/mass;
        double ay = fy/mass;
        double dvx = ax*dt;
        double dvy = ay*dt;
        xxVel = xxVel + dvx;
        yyVel = yyVel + dvy;
        xxPos = xxPos + xxVel*dt;
        yyPos = yyPos + yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images\\"+imgFileName);
        StdDraw.show();
    }
}
