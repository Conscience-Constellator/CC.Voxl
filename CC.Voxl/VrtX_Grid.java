package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import static CC.Math.Calculatr.Invrt1;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.No_Filr;

public
	interface VrtX_Grid
	extends   Voxl_Grid
{
	@Override
	default void Ad_To_SpAc(Physc_SpAc SpAc)
	{SpAc.Ad_Sortd_Object(this);}
	@Override
	default void Rmov_From_SpAc(Physc_SpAc SpAc)
	{SpAc.Rmov_Sortd_Object(this);}

	@Lin_DclAr
	default int CalculAt_X_VrtX_LNg(int LNg)
	{return LNg+1;}
	@Lin_DclAr
	default int CalculAt_Y_VrtX_LNg(int LNg)
	{return LNg+1;}
	@Lin_DclAr
	default int CalculAt_Z_VrtX_LNg(int LNg)
	{return LNg+1;}
	@Lin_DclAr
	RL_LOc_Havr<Physc_SpAc>[][][] Get_VrtXg();
	@Lin_DclAr @Neds_Ovrid(NEds=No)
	default RL_LOc_Havr<Physc_SpAc>[][][] MAk_VrtX_ArA(int X,int Y,int Z)
	{
		return new RL_LOc_Havr
			[CalculAt_Z_VrtX_LNg(Z)]
			[CalculAt_Y_VrtX_LNg(Y)]
			[CalculAt_X_VrtX_LNg(X)];
	}
	@Lin_DclAr
	RL_LOc_Havr<Physc_SpAc>[][][] MAk_VrtXg(int X_Lng,int Y_Lng,int Z_Lng);
	@Lin_DclAr @Neds_Ovrid(NEds=No)
	default RL_LOc_Havr<Physc_SpAc> Get_VrtX(int X,int Y,int Z)
	{return Get_VrtXg()[Z][Y][X];}
	/*Polyhedron*/
		@Lin_DclAr
		void Set_Polyhedron(Polyhedron Polyhedron);
		@Lin_DclAr
		Polyhedron Get_Polyhedron();
	@Lin_DclAr
	default Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> MAk_Polygon(RL_LOc_Havr... VrtXg)
	{return new Drawbl_D3_Polygon<>(new D3_Polygon<>(VrtXg),No_Filr,false);}
	default Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> MAk_X2$2_SId(int X,int Y,int Z)
	{
		int Y_=Y+1,
			Z_=Z+1;
		RL_LOc_Havr<Physc_SpAc>[][][] VrtXg=Get_VrtXg();

		return MAk_Polygon(
			VrtXg[Z_][Y][X],
			VrtXg[Z_][Y_][X],
			VrtXg[Z][Y_][X],
			VrtXg[Z][Y][X]);
	}
	default Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> MAk_Y2$2_SId(int X,int Y,int Z)
	{
		int
			X_=X+1,
			Z_=Z+1;
		RL_LOc_Havr<Physc_SpAc>[][][] VrtXg=Get_VrtXg();

		return MAk_Polygon(
			VrtXg[Z_][Y][X],
			VrtXg[Z_][Y][X_],
			VrtXg[Z][Y][X_],
			VrtXg[Z][Y][X]);
	}
	default Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> MAk_Z2$2_SId(int X,int Y,int Z)
	{
		int X_=X+1,
			Y_=Y+1;
		RL_LOc_Havr[][][] VrtXg=Get_VrtXg();

		return MAk_Polygon(
			VrtXg[Z][Y_][X],
			VrtXg[Z][Y_][X_],
			VrtXg[Z][Y][X_],
			VrtXg[Z][Y][X]);
	}
	default Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> MAk_Z3$2_SId(int X,int Y,int Z)
	{
		int X_=X+1,
			X__=X+2,
			Y_=Y+1;
		RL_LOc_Havr[][][] VrtXg=Get_VrtXg();

		return MAk_Polygon(
			VrtXg[Z][Y_][X],
			VrtXg[Z][Y_][X_],
			VrtXg[Z][Y_][X__],
			VrtXg[Z][Y][X__],
			VrtXg[Z][Y][X_],
			VrtXg[Z][Y][X]
		);
	}
	static int Mid_VrtX_LNg(int LNg)
	{return (LNg+1)*2;}
	default void Ad_Stagrd(int X_LNg,int Y_LNg,int Z_LNg,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][][] X3,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][][] Y3,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][][] Z3)
	{
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][] X2,Y2,Z2;
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[] X1,Y1,Z1;
		int X,X_,Y,Z,
			Stagr;
		for(Z=0;Z<Z_LNg;Z+=1)
		{
			Stagr=0;
			X2=X3[Z];
			for(Y=0;Y<Y_LNg;Y+=1,
				Stagr=Invrt1(Stagr))
			{
				X1=X2[Y];
				for(X=0;X<=X_LNg;X+=1)
				{
					X_=(X*2)+Stagr;
					X1[X]=MAk_X2$2_SId(X_,Y,Z);
				}
			}
		}
		for(Z=0;Z<Z_LNg;Z+=1)
		{
			Y2=Y3[Z];
			for(Y=0;Y<=Y_LNg;Y+=1)
			{
				Y1=Y2[Y];
				for(X=0;X<X_LNg*2;X+=1)
				{Y1[X]=MAk_Y2$2_SId(X,Y,Z);}
			}
		}
		for(Z=0;Z<=Z_LNg;Z+=1)
		{
			Stagr=0;
			Z2=Z3[Z];
			for(Y=0;Y<Y_LNg;Y+=1,
				Stagr=Invrt1(Stagr))
			{
				Z1=Z2[Y];
				for(X=0;X<X_LNg;X+=1)
				{
					X_=(X*2)+Stagr;
					Z1[X]=MAk_Z3$2_SId(X_,Y,Z);
				}
			}
		}
	}
	@Lin_DclAr
	void Ad_Polygong();
	@Lin_DclAr
	default void UpdAt_Polygong()
	{
		Polyhedron Polyhedron=new Polyhedron(this,null);
		Set_Polyhedron(Polyhedron);
		Polyhedron.Set_Drawbl_Atomg();
		Ad_Polygong();
//		for(D3_Polygon[][][] List:new VrtX_Polygon[][][][]{Polygong_X,Polygong_Y,Polygong_Z})
//		{
//			for(int Z=0;Z<Z_LNg;Z+=1)
//			{
//				for(int Y=0;Y<Y_LNg;Y+=1)
//				{
//					for(int X=0;X<X_LNg;X+=1)
//					{
//						if(List[Z][Y][X].Is_Visbl())
//						{throw new RuntimeException(X+","+Y+","+Z);}
////					out.println(Z+","+Y+","+X);
////					out.println(List[Z][Y][X].Colr);
//					}
//				}
//			}
//		}
		Set_Voxlg();
		Polyhedron.UpdAt();
	}
	@Lin_DclAr
	default int CalculAt_X_SId_LNg(int LNg)
	{return LNg+1;}
	@Lin_DclAr
	default int CalculAt_Y_SId_LNg(int LNg)
	{return LNg+1;}
	@Lin_DclAr
	default int CalculAt_Z_SId_LNg(int LNg)
	{return LNg+1;}
}