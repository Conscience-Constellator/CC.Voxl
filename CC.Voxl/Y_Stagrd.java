package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import static DDDTutorial_Modd.Util.Nul_Chek;
import static DDDTutorial_Modd.Voxl.Blok_Typ.Shud_Cul_SId;
import static DDDTutorial_Modd.Voxl.Voxl_Grid.UpdAt_SId;
import static DDDTutorial_Modd.Voxl.VrtX_Grid.Mid_VrtX_LNg;

public abstract class Y_Stagrd
	   extends		Grid_3D
	implements VrtX_Grid
{
	public static final int
		  X_Axis=0,
		XYA_Axis=1,
		XYB_Axis=2,
		  Z_Axis=3;

	public RL_LOc_Havr<Physc_SpAc>[][][] VrtXg;
		@Override
		public RL_LOc_Havr<Physc_SpAc>[][][] Get_VrtXg()
		{return VrtXg;}
		@Override public int CalculAt_X_VrtX_LNg(int LNg)
		{return Mid_VrtX_LNg(LNg);}

	public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][][]
		Polygong_Y,
		Polygong_X,
		Polygong_Z;
		@Override
		public int CalculAt_Y_SId_LNg(int LNg)
		{return LNg*2;}
		@Lin_DclAr
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_Y_SId(int X,int Y,int Z)
		{return Nul_Chek(Polygong_Y[Z][Y][X]);}
		public Polyhedron Polyhedron;
			@Override @Neds_Ovrid(NEds=No)
			public Polyhedron Get_Polyhedron()
			{return Polyhedron;}
			@Override @Neds_Ovrid(NEds=No)
			public void Set_Polyhedron(Polyhedron Polyhedron)
			{this.Polyhedron=Polyhedron;}
		@Override @Neds_Ovrid(NEds=No)
		public int Polygon_Num()
		{
			int Vol=
				X_LNg*
				Y_LNg*
				Z_LNg;

			return (Vol*3)+
				(X_LNg*Y_LNg)+
				(X_LNg*Z_LNg)+
				(Y_LNg*Z_LNg);
		}
	@Override
	public void Set_Voxl_Colr(int X,int Y,int Z,Blok_Typ Typ)
	{}
	@Override
	public void Ad_Polygong()
	{
		Ad_Stagrd(
			X_LNg,Y_LNg,Z_LNg,
			Polygong_X,Polygong_Y,Polygong_Z);
	}
	@Override
	public void Set_Gridg_From_IDg(byte[][][] IDg)
	{
		super.Set_Gridg_From_IDg(IDg);
		VrtXg=MAk_VrtXg(X_LNg,Y_LNg,Z_LNg);
		Polygong_Z=new Drawbl_D3_Polygon[CalculAt_Z_SId_LNg(Z_LNg)][Y_LNg][X_LNg];
		Polygong_Y=new Drawbl_D3_Polygon[Z_LNg][CalculAt_Y_SId_LNg(Y_LNg)][X_LNg*2];
		Polygong_X=new Drawbl_D3_Polygon[Z_LNg][Y_LNg][CalculAt_X_SId_LNg(X_LNg)];
	}

	//<editor-fold desc="SId">
	public void UpdAt_X_SId(Drawbl_D3_Polygon Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.XT(),
					Bot_Typ.Is_TRgetbl(),
					(byte)0b10);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.XB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b01);
			}
			default->{}
		}
	}
	public void UpdAt_Y_SId(Drawbl_D3_Polygon Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.YT(),
					Bot_Typ.Is_TRgetbl(),
					(byte)0b01);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.YB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b10);
			}
			default->{}
		}
	}
	public void UpdAt_Z_SId(Drawbl_D3_Polygon Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.ZT(),
					Bot_Typ.Is_TRgetbl(),
					(byte)0b01);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.ZB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b10);
			}
			default->{}
		}
	}
	//</editor-fold>
	//<editor-fold desc="Axis">
	public void UpdAt_X_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_X_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_X_SId(Top,Mid_Typ,Top_Typ);
	}
		public void UpdAt_X_Axis(
			Blok_Typ Mid_Typ,
			int X,int Y,int Z)
		{
			int X1=X+1;
			UpdAt_X_Axis(
				Polygong_X[Z][Y][X],Get_Voxl_Typ(X-1,Y,Z),
				Mid_Typ,
				Polygong_X[Z][Y][X1],Get_Voxl_Typ(X1,Y,Z));
		}
	public void UpdAt_YA_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_Y_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_Y_SId(Top,Mid_Typ,Top_Typ);
	}
	public void UpdAt_YB_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_Y_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_Y_SId(Top,Mid_Typ,Top_Typ);
	}
		public void UpdAt_Y_Axis(
			Blok_Typ Mid_Typ,
			int X,int Y,int Z)
		{
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][]
				Y2=Polygong_Y[Z];
			int
				Stagr=Y&0b1,
				XB_Neibr_Grid=X-Stagr,
				XT_Neibr_Grid=XB_Neibr_Grid+1,
				XB_Atom_Grid=(X*2)+Stagr,
				XT_Atom_Grid=XB_Atom_Grid+1,
				YT=Y+1,
				YB=Y-1;
			UpdAt_YA_Axis(
				Get_Y_SId(XB_Atom_Grid,Y,Z),Get_Voxl_Typ(XB_Neibr_Grid,YB,Z),
				Mid_Typ,
				Get_Y_SId(XT_Atom_Grid,YT,Z),Get_Voxl_Typ(XT_Neibr_Grid,YT,Z));
			UpdAt_YB_Axis(
				Get_Y_SId(XB_Atom_Grid,YT,Z),Get_Voxl_Typ(XB_Neibr_Grid,YT,Z),
				Mid_Typ,
				Get_Y_SId(XT_Atom_Grid,Y,Z),Get_Voxl_Typ(XT_Neibr_Grid,YB,Z));
		}
	public void UpdAt_Z_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_Z_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_Z_SId(Top,Mid_Typ,Top_Typ);
	}
		public void UpdAt_Z_Axis(
			Blok_Typ Mid_Typ,
			int X,int Y,int Z)
		{
			int Z1=Z+1;
			UpdAt_Z_Axis(
				Polygong_Z[Z][Y][X],Get_Voxl_Typ(X,Y,Z-1),
				Mid_Typ,
				Polygong_Z[Z1][Y][X],Get_Voxl_Typ(X,Y,Z1));
		}
	//</editor-fold>
	@Override
	public void UpdAt_Srfac(int X,int Y,int Z,Blok_Typ Typ)
	{
//		out.println("UpdAt_Srfac");

		UpdAt_X_Axis(Typ,X,Y,Z);
		UpdAt_Y_Axis(Typ,X,Y,Z);
		UpdAt_Z_Axis(Typ,X,Y,Z);
	}

	@Override
	public void Get_Bordr_Out_Box_StRt(double[] Box)
	{}
	@Override
	public void Get_Bordr_Out_Box(double[] Box)
	{}

	public Y_Stagrd(RL_LOc_Havr<Physc_SpAc> Parnt,Object LOc_SOrc,double Voxl_SIz,byte[][][] IDg)
	{
		super(Parnt,LOc_SOrc,Voxl_SIz,IDg);
		UpdAt_Polygong();
	}
}