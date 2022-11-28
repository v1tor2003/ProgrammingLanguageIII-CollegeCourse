package List07.base.alunos;

public enum TipoCursos {
  
  NAO_INFORMADO("", 0),
  ENGENHARIAS("engenharias", 0.2f), 
  COMPUTACAO("computacao", 0.1f), 
  LETRAS("letras", 0.05f), 
  BIOLOGICAS("biologicas", 0);

  final String courseType;
  final float courseTax;

  TipoCursos (String courseType, float tax){
    this.courseType = courseType;
    this.courseTax = tax;
  }

}
