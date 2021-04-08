package src;

public class date {
    private int year;
    private int month;
    private int day;
    public date(int year,int month,int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public date(date d){
        this.year=d.year;
        this.month=d.month;
        this.day=d.day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
