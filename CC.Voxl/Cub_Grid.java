package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.Gom;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import static CC.List.BAs_ArA.ABC;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Grid$SpAc;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.ArA$String;

public abstract class Cub_Grid extends Grid_3D
{
	public void To_SpAc(double[] Blok_LOc,
		int X,
		int Y,
		int Z,
		double[] LOc)
	{Gom.Grid$SpAc(Blok_LOc,X,Y,Z,Voxl_SIz,LOc);}

	public static int Get_SId_Axis(double[] Box)
	{
		return
			(Box[0]==Box[1])?0:
			(Box[2]==Box[3])?1:
			(Box[4]==Box[5])?2:
			-1;
	}
	//<editor-fold desc="Get_SId_Polygon">
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_XB_Polygon(int X,int Y,int Z);
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_XT_Polygon(int X,int Y,int Z);
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_YB_Polygon(int X,int Y,int Z);
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_YT_Polygon(int X,int Y,int Z);
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_ZB_Polygon(int X,int Y,int Z);
	@Lin_DclAr
	public abstract Drawbl_D3_Polygon Get_ZT_Polygon(int X,int Y,int Z);
	//</editor-fold>

	@Override
	public void Set_Voxl_Colr(int X,int Y,int Z,Blok_Typ Typ)
	{
		Get_XB_Polygon(X,Y,Z).Set_Filr(Typ.XB());
		Get_XT_Polygon(X,Y,Z).Set_Filr(Typ.XT());
		Get_YB_Polygon(X,Y,Z).Set_Filr(Typ.YB());
		Get_YT_Polygon(X,Y,Z).Set_Filr(Typ.YT());
		Get_ZB_Polygon(X,Y,Z).Set_Filr(Typ.ZB());
		Get_ZT_Polygon(X,Y,Z).Set_Filr(Typ.ZT());
	}
	//<editor-fold desc="OpaciT">
		/*Later system based on whether opposite side of block touching that side is transparent.*/
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public boolean Is_X_SId_Visbl(int X,int Y,int Z,int SId)
		{return !Is_Opaq_Voxl(X+SId,Y,Z);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_XB_Visbl(int X,int Y,int Z)
			{return Is_X_SId_Visbl(X,Y,Z,-1);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_XT_Visbl(int X,int Y,int Z)
			{return Is_X_SId_Visbl(X,Y,Z,1);}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public boolean Is_Y_SId_Visbl(int X,int Y,int Z,int SId)
		{return !Is_Opaq_Voxl(X,Y+SId,Z);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_YB_Visbl(int X,int Y,int Z)
			{return Is_Y_SId_Visbl(X,Y,Z,-1);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_YT_Visbl(int X,int Y,int Z)
			{return Is_Y_SId_Visbl(X,Y,Z,1);}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public boolean Is_Z_SId_Visbl(int X,int Y,int Z,int SId)
		{return !Is_Opaq_Voxl(X,Y,Z+SId);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_ZB_Visbl(int X,int Y,int Z)
			{return Is_Z_SId_Visbl(X,Y,Z,-1);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_ZT_Visbl(int X,int Y,int Z)
			{return Is_Z_SId_Visbl(X,Y,Z,1);}
	//</editor-fold>

	//<editor-fold desc="Box">
	@Override
	public void Get_Bordr_Out_Box_StRt(double[] Box)
	{
		Out_Box_Getbl.UpdAt_Out_Box_From_StRt(Box,Get_LOc_CoP_As_ArA(),
			X_LNg,
			Y_LNg,
			Z_LNg
		);}
	@Override
	public void Get_Bordr_Out_Box(double[] Box)
	{
		Out_Box_Getbl.UpdAt_Out_Box_From(Box,Get_LOc_CoP_As_ArA(),
		X_LNg,
		Y_LNg,
		Z_LNg
	);}
	//</editor-fold>

	public Cub_Grid(RL_LOc_Havr Parnt,Object Loc_Sorc,double Voxl_SIz,byte[][][] IDg)
	{super(Parnt,Loc_Sorc,Voxl_SIz,IDg);}
}