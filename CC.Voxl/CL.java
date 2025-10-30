package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Gom.*;
import static CC.Math.Cyclr.Cycl;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.Set_A;
import static CC.List.ArA_X.Get_Last;
import static MAn.MAn.Warnng_Colr;
import static java.awt.Color.*;

public class CL extends SqAr_Grid
{
	@Finishd(Is_Finishd=false)
	public static void ConwA_Typg(Voxl_Typ[] Typg,Voxl_Typ Ded,Voxl_Typ AlIv)
	{
		Typg[0]=Ded;
		Typg[1]=AlIv;
	}
		@Finishd(Is_Finishd=true)
		public static Voxl_Typ[] ConwA_Typg(Voxl_Typ Ded,Voxl_Typ AlIv)
		{
			Voxl_Typ[] Typg=new Voxl_Typ[128];
			ConwA_Typg(Typg,Ded,AlIv);

			return Typg;
		}
	public static Voxl_Typ[] ConwA_Typg=ConwA_Typg(
		new Voxl_Typ(!false,
//			ClEr
			Warnng_Colr
			,false),
		new Voxl_Typ(true,Set_A(white,64),true)
	);
		@Override @Finishd(Is_Finishd=false)
		public Voxl_Typ[] Get_Typg()
		{return ConwA_Typg;}
		static
		{ConwA_Typg[2]=new Voxl_Typ(false,Warnng_Colr,false);}
	public int[][] IDg_New;

	@Override @Finishd(Is_Finishd=false)
	public void Set_Gridg_From_IDg(int[][] IDg)
	{
		super.Set_Gridg_From_IDg(IDg);
		IDg_New=new int[Y_LNg][X_LNg];
	}

	//<editor-fold desc="Rul">
	@Finishd(Is_Finishd=false)
	public static int NXt_ID(int Crnt,int Neibr)
	{
		if(Crnt>0)
		{return (Neibr>=2&&Neibr<=3)?1:0;}
		else if(Neibr==3)
		{return 1;}
		else{return 0;}
	}
	@Finishd(Is_Finishd=false)
	public static int NXt_ID(int Crnt,float Neibr)
	{
		if(Crnt>0)
		{return (Neibr>=2&&Neibr<=3)?1:0;}
		else if(Neibr==3)
		{return 1;}
		else{return 0;}
	}
	@Finishd(Is_Finishd=false)
	public interface NXt_ID_Getr
	{
		@Lin_DclAr
		void NXt(int[] IDg,int X,
			int AA,int AB,int AC,
			int BA,int Crnt,int BC,
			int CA,int CB,int CC);
	}
	public NXt_ID_Getr ConwAs_GAm_O_LIf=(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,
			AA+AB+AC+
			BA+/**/BC+
			CA+CB+CC
		);};
	public NXt_ID_Getr[] ConwAs_GAm_O_LIf_TSt={
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA*.5)+(AB*.75)+AC+
			(BA*.75)+/**/(BC*.75)+
			CA+(CB*.75)+(CC*.5)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA/2)+(AB/2)+(AC/2)+
			(BA/2)+/**/(BC/2)+
			(CA/2)+(CB/2)+(CC/2)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA/4)+(AB/4)+(AC/4)+
			(BA/4)+/**/(BC/4)+
			(CA/4)+(CB/4)+(CC/4)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA/3)+(AB/3)+(AC/3)+
			(BA/3)+/**/(BC/3)+
			(CA/3)+(CB/3)+(CC/3)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA/2.5)+(AB/2.5)+(AC/2.5)+
			(BA/2.5)+/**/(BC/2.5)+
			(CA/2.5)+(CB/2.5)+(CC/2.5)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA/2.25)+(AB/2.25)+(AC/2.25)+
			(BA/2.25)+/**/(BC/2.25)+
			(CA/2.25)+(CB/2.25)+(CC/2.25)
		));},
		(IDg,X,
			AA,AB,AC,
			BA,Crnt,BC,
			CA,CB,CC
		)->{IDg[X]=NXt_ID(Crnt,(int)(
			(AA*.5)+(AB*.75)+AC+
			(BA*.75)+/**/(BC*.75)+
			CA+(CB*.75)+(CC*.5)
		));},
	};
	public NXt_ID_Getr NXt_ID_Getr=
		(false)?ConwAs_GAm_O_LIf:
		Get_Last(ConwAs_GAm_O_LIf_TSt)
	;
	//</editor-fold>

	public void UpdAt_Voxl(int X,int Y,Voxl_Typ Typ)
	{
		Polygong[Y][X].Set_Atom(
			Typ.Is_Visbl,
			Typ.Filr,
			Typ.Is_TRgetbl);
	}

	@Override @Finishd(Is_Finishd=false)
	public void Tik()
	{
		for(int Y=0;Y<Y_LNg;Y+=1)
		{
			int[]
				A=IDg[Cycl(Y-1,Y_LNg)],
				B=IDg[Y],
				C=IDg[(Y+1)%Y_LNg],
				B_New=IDg_New[Y];
			for(int X=0;X<X_LNg;X+=1)
			{
				int
					XB=Cycl(X-1,X_LNg),
					XT=(X+1)%X_LNg;
				NXt_ID_Getr.NXt(B_New,X,
					A[XB],A[X],A[XT],
					B[XB],B[X],B[XT],
					C[XB],C[X],C[XT]);
			}
		}

		/**Swap IDg.*/
		int[][] IDg_StOr=IDg;
		IDg=IDg_New;
		IDg_New=IDg_StOr;

		UpdAt_Voxlg();
	}

	@Override @Finishd(Is_Finishd=false)
	public void Intract(Drawbl_Atom Atom)
	{
		int[] Loc=Get_LOc((D3_Drawbl_Atom)Atom);
		IDg[Loc[1]][Loc[0]]=1;
	}

	public CL(RL_LOc_Havr Parnt,Object LOc_SOrc,
		double Voxl_SIz,int X_LNg,int Y_LNg,int[][] IDg)
	{super(Parnt,LOc_SOrc,Voxl_SIz,X_LNg,Y_LNg,IDg);}
		/**Infers, X_LNg, & Y_LNg.*/
		public CL(RL_LOc_Havr Parnt,Object LOc_SOrc,
			double Voxl_SIz,int[][] IDg)
		{super(Parnt,LOc_SOrc,Voxl_SIz,IDg);}
}