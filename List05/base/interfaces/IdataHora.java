package base.interfaces;

import base.data_hora.DataHoraComp;

public interface IdataHora {
  @Override
  String toString();
  boolean isEqual(DataHoraComp outra);
  boolean isGreater(DataHoraComp outra);
  boolean isLower(DataHoraComp outra);
}
