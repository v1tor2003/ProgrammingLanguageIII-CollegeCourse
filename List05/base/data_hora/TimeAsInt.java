package base.data_hora;
public class TimeAsInt {
    private int value;

    public TimeAsInt(int hora, int minuto, int segundo){
      int value = timeToSeconds(hora, minuto, segundo);
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
      this.value += timeToSeconds(h, m, s);
    }

    public void addTime(TimeAsInt obj){
      this.value += obj.value;
    }

    private boolean validateTime(int timeValue){
        return ((timeValue>0) && (timeValue<86401));//SegundosEmUmDia = 24*60*60 = 86400 
    }

    public boolean isPrevious(TimeAsInt outraHora){
      if(howManySeconds(outraHora) >= 0)
        return false;
      
      return true;
    }

    public int howManySeconds(TimeAsInt outraHora){
      return outraHora.value - this.value;
    }

    private int timeToSeconds(int hora, int min, int sec){
        return hora*3600 + min*60 + sec;
    }

    private String secondsToTime(){
      final int conditionToShow0 = 10;
      
      String horaStr = formatIntegerOutput(value/3600, conditionToShow0);
      String minStr = formatIntegerOutput((value % 3600)/60, conditionToShow0); 
      String secStr = formatIntegerOutput((value % 3600)%60, conditionToShow0);
      
      return String.format("%s:%s:%s", horaStr, minStr, secStr);
    }

    private String formatIntegerOutput(int input, int conditional){
      String output = Integer.toString(input);

      if(input < conditional)
        return output = "0" + output;
      
      return output;
    }

    public void setTime(int hora, int min, int seg){
      int value = this.timeToSeconds(hora, min, seg);
      if (validateTime(value))
        this.value = value;
      else
        this.value = 0;
    }

    public int getTimeAsSeconds(){
      return this.value;
    }

    public String toString(){
      return secondsToTime();
    }
}