package List07.base.alunos;

public enum Nivel {
  M(24),
  D(48);

  final int tempoCurso;

  Nivel (int tempoCurso){
    this.tempoCurso = tempoCurso;
  }
}
