package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc_Ocupier;

public interface Voxl_Grid extends SpAc_Ocupier<Physc_SpAc>,Out_Box_Getbl
{
	@Override
	default int Get_Dim_Num()
	{return 3;}

	@Lin_DclAr
	int Polygon_Num();
	@Lin_DclAr
	void Set_Gridg_From_IDg(byte[][][] IDg);

	@Lin_DclAr
	void Get_Atom_LOc(D3_Drawbl_Atom Atom,double[] Box,int[] Loc);
	@Lin_DclAr
	int Get_Atom_LOc_Al_Axis(D3_Drawbl_Atom Atom,double[] Box,int[] Loc);
	@Lin_DclAr
	int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom)
		{
			int[] Loc=new int[3];

			return Get_TRgetbl_Voxl(Atom,Loc);
		}
	@Lin_DclAr
	int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		default int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom)
		{
			int[] Loc=new int[3];
			return Get_UntRgetbl_Voxl(Atom,Loc);
		}
	@Lin_DclAr
	void PlAc_On_Voxl(D3_Drawbl_Atom Atom,byte ID);

	static void UpdAt_SId(D3_Drawbl_Atom Atom,
		Blok_Typ Atom_Typ,
		Blok_Typ Neibr_Typ)
	{
		Atom.Set_Is_Visbl(
			Atom_Typ.OpaciT()!=
			Neibr_Typ.OpaciT());
		Atom.Set_Is_TRgetbl(
			Atom_Typ.Is_TRgetbl()!=
			Neibr_Typ.Is_TRgetbl());
	}

	@Lin_DclAr
	void Set_Voxlg();

	abstract class Voxl_Grid_ConcrEt extends RL_LOc_Havr_ConcrEt<Physc_SpAc>
		implements Voxl_Grid
	{
		public Voxl_Grid_ConcrEt(RL_LOc_Havr<Physc_SpAc> Parnt,Object LOc_SOrc)
		{
			super(Parnt,LOc_SOrc);
			Get_SpAc().Ad_Sortd_Object(this,"Voxl_Grid");
		}
	}
}