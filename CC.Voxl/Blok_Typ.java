package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import CC.Encycloped.Abs.Org.Comput.Bi.Byt0_Modr;
import CC.Util.Prim.Int_Havr.Int_Havr_Imp;
import java.awt.*;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.ClEr;
import static java.awt.Color.*;

public interface Blok_Typ
{
	@Lin_DclAr
	byte Get_ID();

	@Lin_DclAr
	default void UpdAt(Grid_3D Grid,
		int X,int Y,int Z)
	{
		Grid.Set_Voxl_Colr(X,Y,Z,this);
		Grid.UpdAt_Srfac(X,Y,Z,this);
	}

	@Lin_DclAr
	byte OpaciT();
	Filr XB();Filr XT();
	Filr YB();Filr YT();
	Filr ZB();Filr ZT();

	@Lin_DclAr
	boolean Is_TRgetbl();

	String Get_NAm();

	class Standrd_Blok_Typ implements Blok_Typ
	{
		public <Typ>Standrd_Blok_Typ(byte ID,String NAm,boolean Is_TRgetbl,
			byte OpaciT,Typ... SIdg)
		{
			this.ID=ID;
			this.NAm=NAm;

			this.Is_TRgetbl=Is_TRgetbl;

			Object Bot=SIdg[0],Top,Bak,Fro,LFt,Rit;
			if(SIdg.length==1)
			{
				Top=Bot;
				Bak=Bot;Fro=Bot;
				LFt=Bot;Rit=Bot;
			}
			else
			{
				Top=SIdg[1];
				Bak=SIdg[2];Fro=SIdg[3];
				LFt=SIdg[4];Rit=SIdg[5];
			}
			Set_SIdg(
				LFt,Rit,
				Bak,Fro,
				Bot,Top);

			this.OpaciT=OpaciT;

			Registr_Blok_Typ(this);
		}

		public byte ID;
			@Override
			public byte Get_ID()
			{return ID;}
		public String NAm;
			@Override
			public String Get_NAm()
			{return NAm;}
				@Override
				public String toString()
				{return Get_NAm();}

		public boolean Is_TRgetbl;
			@Override
			public boolean Is_TRgetbl()
			{return Is_TRgetbl;}

		//<editor-fold desc="Graphcs">
		Filr
			Bot,Top,
			Bak,Fro,
			LFt,Rit;
		@Override public Filr XB(){return Bot;}@Override public Filr XT(){return Top;}
		@Override public Filr YB(){return Bak;}@Override public Filr YT(){return Fro;}
		@Override public Filr ZB(){return LFt;}@Override public Filr ZT(){return Rit;}
		public void Set_SIdg(
			Object XB,Object XT,
			Object YB,Object YT,
			Object ZB,Object ZT)
		{
			Bot=Filr.Gar_Filr(ZB);Top=Filr.Gar_Filr(ZT);
			Bak=Filr.Gar_Filr(YB);Fro=Filr.Gar_Filr(YT);
			LFt=Filr.Gar_Filr(XB);Rit=Filr.Gar_Filr(XT);
		}
		public byte OpaciT;
			@Override
			public byte OpaciT()
			{return OpaciT;}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public Standrd_Blok_Typ Clarfy()
		{
			Byt0_Modr Mod=new Byt0_Modr(new Int_Havr_Imp(128));
			Bot.Mod(Mod);Top.Mod(Mod);
			Bak.Mod(Mod);Fro.Mod(Mod);
			LFt.Mod(Mod);Rit.Mod(Mod);

			return this;
		}
		//</editor-fold>
	}

	Blok_Typ[] Blok_Typg=new Blok_Typ[256];
		static byte LOst_UnUsd_ID()
		{
			for(byte ID=0;ID<127;ID+=1)
			{
				if(Blok_Typg[ID]==null)
				{return ID;}
			}
			return -1;
		}
	static Blok_Typ Registr_Blok_Typ(Blok_Typ Typ)
	{
		Blok_Typg[Typ.Get_ID()]=Typ;

		return Typ;
	}
	final byte
		Invisbl=0,
		BtwEn=1,
		Opaq=2,
		Opaq2=Shud_Cul_SId(Opaq,Opaq),
		BtwEn2=Shud_Cul_SId(BtwEn,BtwEn),
		Invisbl2=Shud_Cul_SId(Invisbl,Invisbl),
		SAm=10;

	@Lin_DclAr
	static byte Shud_Cul_SId(
		byte A,
		byte B)
	{
		return (byte)(
			A|
			B<<2);
	}
		@Lin_DclAr
		static byte Shud_Cul_SId(
			Blok_Typ A,
			Blok_Typ B)
		{
			return (A==B)?
				SAm:
				Shud_Cul_SId(
					A.OpaciT(),
					B.OpaciT());
		}
	Blok_Typ
		Non=new Standrd_Blok_Typ((byte)127,"None",
			false,Invisbl,ClEr)
		{
			@Override
			public void UpdAt(Grid_3D Grid,int X,int Y,int Z)
			{}
		},
		VacUm=new Standrd_Blok_Typ((byte)0,"Vacuum",
			false,Invisbl,ClEr)
		{},
		Drt=new Standrd_Blok_Typ((byte)1,"Dirt",
			true,Opaq,
			new Color(100,40,40,128))
		{},
		Compas=new Standrd_Blok_Typ((byte)2,"Compass",
			true,Opaq,
			red,blue,
			orange,green,
			yellow,magenta)
		{
		}.Clarfy(),
		Watr=new Standrd_Blok_Typ((byte)3,"Water",
			false,Blok_Typ.BtwEn,
			new Color(0,0,255,16))
	;
}