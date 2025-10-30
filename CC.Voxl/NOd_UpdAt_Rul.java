package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.NOd_Object;

public interface NOd_UpdAt_Rul<NOd_Typ extends NOd_Object>
{
	@Lin_DclAr @Finishd(Is_Finishd=false)
	void CalculAt(NOd_Typ NOd);

	NOd_UpdAt_Rul No_Rul=(Setr)->{};
}