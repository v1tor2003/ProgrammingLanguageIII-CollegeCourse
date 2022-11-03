public class TimeAsInt {
    private int value;

    public TimeAsInt(int hora, int minuto, int segundo){
      int value = TimeToSeconds(hora, minuto, segundo);
      if(validateTime(value))
        this.value = value;
      else
        this.value = 0;
    }

    public TimeAsInt(){
      this(0,0,0);
    }

    public TimeAsInt(int hora){
      this(hora, 0, 0);
    }

    public TimeAsInt(int hora, int minuto){
      this(hora, minuto, 0);
    }

    public TimeAsInt(TimeAsInt obj){
      this(0, 0, obj.value);
    }

    public boolean isAm(){
      final int midDay = 12;
      return ((value/3600) < midDay);
    }
    
    public int cron(TimeAsInt outraHora){
      final int segundosEmUmDia = 86400;
      int result = Math.abs(outraHora.value - this.value);
      
      if(outraHora.value < this.value)
        return result+= segundosEmUmDia;
      
        return result;
    }

    public void addTime(int s){
      this.value += s;
    }

    public void addTime(int m, int s){
      this.value += (m * 60 + s);
    }

    public void addTime(int h, int m, int s){
      this.value += TimeToSeconds(h, m, s);
    }

    public void addTime(TimeAsInt obj){
      this.value += obj.value;
    }

    private boolean validateTime(int timeValue){
        return ((timeValue>0) && (timeValue<86401));//SegundosEmUmDia = 24*60*60 = 86400 
    }

    private int TimeToSeconds(int hora, int min, int sec){
        return hora*3600 + min*60 + sec;
    }

    private String SecondsToTime(){
        String result = "";
        int hora;
        int min;
        int sec;

        hora = value/3600;
        min = (value % 3600)/60;
        sec = (value % 3600)%60;

        result = Integer.toString(hora) + ":"
               + Integer.toString(min) + ":"
               + Integer.toString(sec);

        return result;
    }

    public void setTime(int hora, int min, int seg){
        int value = this.TimeToSeconds(hora, min, seg);
        if (validateTime(value)) {
            this.value = value;
        }
        else{
            this.value = 0;
        }
    }

    public String getTime(){
        String res = SecondsToTime();
        return res;
    }

    public void prnTime(){
        System.out.print(getTime());
    }
}