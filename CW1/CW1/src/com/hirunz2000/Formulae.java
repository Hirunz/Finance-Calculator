package com.hirunz2000;

public class Formulae {

    /*
    A = the future value of the investment/loan, including interest.
    P = the principal investment amount (the initial deposit or loan amount - present value).
    r = annual interest rate.
    n = the number of times that interest is compounded per unit time(this is always monthly for the purpose of thisCW).
    t = the time the money is invested or borrowed in years.
    PMT = payments amount per month
    */

    private double A;
    private double P;
    private double r;
    public static final int n=12;
    private double t;
    private double PMT;
    private double FV;



//--------------------------------------------------Fixed deposit-----------------------------------------------------//

    public double presentValue(double t,double A, double r){
        this.A=A;
        this.r=(r/100)/n;
        this.t=t*n;
        this.P= this.A/Math.pow(1+this.r,this.t);
        return this.P;
    }

    public double futureValue(double t,double P, double r){
        this.P=P;
        this.r=(r/100)/n;
        this.t=t*n;
        this.A= this.P*(Math.pow(1+this.r,this.t));
        return this.A;
    }

    public double interestRate(double t,double P, double A){
        this.P=P;
        this.A=A;
        this.t=t*n;
        this.r= n*(Math.pow((this.A/this.P),(1.0/this.t))-1)*100;

        return this.r;
    }

    public double timePeriod(double A,double P, double r){
        this.P=P;
        this.r=(r/100)/n;
        this.A=A;
        double t= Math.round(Math.log(this.A/this.P)/(n*Math.log(1+this.r)));
        return t;
    }

//--------------------------------------------------------------------------------------------------------------------//
//--------------------------------------------------Savings calculator------------------------------------------------//

    public double FV(double PMT,double P,double r, double t){
        this.PMT=PMT;
        this.P=P;
        this.r=(r/100)/n;
        this.t=t*n;
        this.FV=(this.PMT*(Math.pow(1+this.r,this.t)-1)/this.r) + this.P*Math.pow(1+this.r,this.t);
        return this.FV;
    }

    public double P(double PMT, double A, double r, double t){
        this.PMT=PMT;
        this.A=A;
        this.r=(r/100)/n;
        this.t=t*n;
        this.P=(this.A*this.r-this.PMT*(Math.pow(1+this.r,this.t)-1))/(this.r*Math.pow(1+this.r,this.t));
        return this.P;
    }

    public double PMT(double P,double A,double r, double t){
        this.P=P;
        this.A=A;
        this.r=(r/100)/n;
        this.t=t*n;
        this.PMT=this.r*(this.A-this.P*Math.pow(1+this.r,this.t))/(Math.pow(1+this.r,this.t)-1);
        return this.PMT;
    }

    public double time(double P,double A,double r, double PMT){
        this.P=P;
        this.A=A;
        this.r=(r/100)/n;
        this.PMT=PMT;
        this.t=(Math.log(((this.A*this.r+this.PMT)/(this.P*this.r+this.PMT))))/Math.log(1+this.r);
        return this.t/n;
    }



//--------------------------------------------------------------------------------------------------------------------//
//--------------------------------------------------Mortgage and loan-------------------------------------------------//

    public double PMT(double P, double r, double t){
        this.P=P;
        this.r=(r/100)/n;
        this.t=t*n;
        double ans=(this.P* this.r *Math.pow(1+ this.r, this.t))/(Math.pow(1+ this.r, this.t)-1);
        return ans ;
    }

    public double LoanAmount(double PMT,double t, double r){
        this.PMT=PMT;
        this.r=(r/100)/n;
        this.t=t*n;
        double ans=(this.PMT*(Math.pow(1+ this.r, this.t)-1)/( this.r *Math.pow(1+ this.r, this.t)));
        return ans ;
    }

    public double LoanTerm(double P,double PMT, double r){
        this.PMT=PMT;
        this.r=(r/100)/n;
        this.P=P;
        this.t=Math.log(this.PMT/(this.PMT-this.r*this.P))/Math.log(1+this.r);
        return this.t/n;
    }

    }
//********************************************************************************************************************//