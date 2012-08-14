package br.random.bean;

import br.random.dao.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class VampireChar extends Char {
	private String nature;
	private String demeanor;
	private String clan;
	private int generation;
	private String haven;
	private String concept;
	private int strength;
	private int dexterity;
	private int stamina;
	private int charisma;
	private int manipulation;
	private int appearance;
	private int perception;
	private int intelligence;
	private int wits;
	private int acting;
	private int alertness;
	private int athletics;
	private int brawl;
	private int dodge;
	private int empathy;
	private int intimidation;
	private int leadership;
	private int streetwise;
	private int subterfuge;
	private int animalken;
	private int drive;
	private int etiquette;
	private int firearms;
	private int melee;
	private int music;
	private int repair;
	private int security;
	private int stealth;
	private int survival;
	private int bureaucracy;
	private int computer;
	private int finance;
	private int investigation;
	private int law;
	private int linguistics;
	private int medicine;
	private int occult;
	private int politics;
	private int science;
	private String discipline1;
	private int discipline1val;
	private String discipline2;
	private int discipline2val;
	private String discipline3;
	private int discipline3val;
	private String discipline4;
	private int discipline4val;
	private String discipline5;
	private int discipline5val;
	private String background1;
	private int background1val;
	private String background2;
	private int background2val;
	private String background3;
	private int background3val;
	private String background4;
	private int background4val;
	private String background5;
	private int background5val;
	private int conscience;
	private int selfcontrol;
	private int courage;
	private String trait1;
	private int trait1val;
	private String trait2;
	private int trait2val;
	private String trait3;
	private int trait3val;
	private String trait4;
	private int trait4val;
	private String trait5;
	private int trait5val;
	private String weapon1;
	private int weapon1diff;
	private int weapon1dam;
	private String weapon2;
	private int weapon2diff;
	private int weapon2dam;
	private String weapon3;
	private int weapon3diff;
	private int weapon3dam;
	private int humanity;
	private int willpower;
	private int willpowercur;
	private int bloodpool;
	private String health;
	private int experience;
	private int experiencecur;
	private int PHYSIC_LEFT;
	private int SOCIAL_LEFT;
	private int MENTAL_LEFT;
	private int TALENT_LEFT;
	private int SKILL_LEFT;
	private int KNOWLEDGE_LEFT;
	private int DISCIPLINE_LEFT;
	private int BACKGROUND_LEFT;
	private int VIRTUE_LEFT;
	
	public VampireChar() {
		strength = dexterity = stamina = charisma = manipulation = appearance = perception = intelligence = wits = 1;
		background1 = background2 = background3 = background4 = background5 = discipline1 = discipline2 = discipline3 = discipline4 = discipline5 = "";
		clan = "";
		generation = 13;
		PHYSIC_LEFT = 7;
		SOCIAL_LEFT = 5;
		MENTAL_LEFT = 3;
		TALENT_LEFT = 13;
		SKILL_LEFT = 9;
		KNOWLEDGE_LEFT = 5;
		DISCIPLINE_LEFT = 3;
		BACKGROUND_LEFT = 5;
		VIRTUE_LEFT = 7;
	}
	
	public String getNature() { return nature; }
	public String getDemeanor() { return demeanor; }
	public String getClan() { return clan; }
	public int getGeneration() { return generation; }
	public String getHaven() { return haven; }
	public String getConcept() { return concept; }
	public int getStrength() { return strength; }
	public int getDexterity() { return dexterity; }
	public int getStamina() { return stamina; }
	public int getCharisma() { return charisma; }
	public int getManipulation() { return manipulation; }
	public int getAppearance() { return appearance; }
	public int getPerception() { return perception; }
	public int getIntelligence() { return intelligence; }
	public int getWits() { return wits; }
	public int getActing() { return acting; }
	public int getAlertness() { return alertness; }
	public int getAthletics() { return athletics; }
	public int getBrawl() { return brawl; }
	public int getDodge() { return dodge; }
	public int getEmpathy() { return empathy; }
	public int getIntimidation() { return intimidation; }
	public int getLeadership() { return leadership; }
	public int getStreetwise() { return streetwise; }
	public int getSubterfuge() { return subterfuge; }
	public int getAnimalken() { return animalken; }
	public int getDrive() { return drive; }
	public int getEtiquette() { return etiquette; }
	public int getFirearms() { return firearms; }
	public int getMelee() { return melee; }
	public int getMusic() { return music; }
	public int getRepair() { return repair; }
	public int getSecurity() { return security; }
	public int getStealth() { return stealth; }
	public int getSurvival() { return survival; }
	public int getBureaucracy() { return bureaucracy; }
	public int getComputer() { return computer; }
	public int getFinance() { return finance; }
	public int getInvestigation() { return investigation; }
	public int getLaw() { return law; }
	public int getLinguistics() { return linguistics; }
	public int getMedicine() { return medicine; }
	public int getOccult() { return occult; }
	public int getPolitics() { return politics; }
	public int getScience() { return science; }
	public int getPhysicLeft() { return PHYSIC_LEFT; }
	public int getSocialLeft() { return SOCIAL_LEFT; }
	public int getMentalLeft() { return MENTAL_LEFT; }
	public int getTalentLeft() { return TALENT_LEFT; }
	public int getSkillLeft() { return SKILL_LEFT; }
	public int getKnowledgeLeft() { return KNOWLEDGE_LEFT; }
	public int getDisciplineLeft() { return DISCIPLINE_LEFT; }
	public int getBackgroundLeft() { return BACKGROUND_LEFT; }
	public int getVirtueLeft() { return VIRTUE_LEFT; }
	
	public String getDiscipline1() { return discipline1; }
	public int getDiscipline1val() { return discipline1val; }
	public String getDiscipline2() { return discipline2; }
	public int getDiscipline2val() { return discipline2val; }
	public String getDiscipline3() { return discipline3; }
	public int getDiscipline3val() { return discipline3val; }
	public String getDiscipline4() { return discipline4; }
	public int getDiscipline4val() { return discipline4val; }
	public String getDiscipline5() { return discipline5; }
	public int getDiscipline5val() { return discipline5val; }
	public String getBackground1() { return background1; }
	public int getBackground1val() { return background1val; }
	public String getBackground2() { return background2; }
	public int getBackground2val() { return background2val; }
	public String getBackground3() { return background3; }
	public int getBackground3val() { return background3val; }
	public String getBackground4() { return background4; }
	public int getBackground4val() { return background4val; }
	public String getBackground5() { return background5; }
	public int getBackground5val() { return background5val; }
	public int getConscience() { return conscience; }
	public int getSelfcontrol() { return selfcontrol; }
	public int getCourage() { return courage; }
	public String getTrait1() { return trait1; }
	public int getTrait1val() { return trait1val; }
	public String getTrait2() { return trait2; }
	public int getTrait2val() { return trait2val; }
	public String getTrait3() { return trait3; }
	public int getTrait3val() { return trait3val; }
	public String getTrait4() { return trait4; }
	public int getTrait4val() { return trait4val; }
	public String getTrait5() { return trait5; }
	public int getTrait5val() { return trait5val; }
	public String getWeapon1() { return weapon1; }
	public int getWeapon1diff() { return weapon1diff; }
	public int getWeapon1dam() { return weapon1dam; }
	public String getWeapon2() { return weapon2; }
	public int getWeapon2diff() { return weapon2diff; }
	public int getWeapon2dam() { return weapon2dam; }
	public String getWeapon3() { return weapon3; }
	public int getWeapon3diff() { return weapon3diff; }
	public int getWeapon3dam() { return weapon3dam; }
	public int getHumanity() { return humanity; }
	public int getWillpower() { return willpower; }
	public int getWillpowercur() { return willpowercur; }
	public int getBloodpool() { return bloodpool; }
	public String getHealth() { return health; }
	public int getExperience() { return experience; }
	public int getExperiencecur() { return experiencecur; }
	public void setNature(String nature) { this.nature = nature; }
	public void setDemeanor(String demeanor) { this.demeanor = demeanor; }
	public void setClan(String clan) { this.clan = clan; }
	public void setGeneration(int generation) { this.generation = generation; }
	public void setHaven(String haven) { this.haven = haven; }
	public void setConcept(String concept) { this.concept = concept; }
	public void setStrength(int strength) { this.strength = strength; }
	public void setDexterity(int dexterity) { this.dexterity = dexterity; }
	public void setStamina(int stamina) { this.stamina = stamina; }
	public void setCharisma(int charisma) { this.charisma = charisma; }
	public void setManipulation(int manipulation) { this.manipulation = manipulation; }
	public void setAppearance(int appearance) { this.appearance = appearance; }
	public void setPerception(int perception) { this.perception = perception; }
	public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
	public void setWits(int wits) { this.wits = wits; }
	public void setActing(int acting) { this.acting = acting; }
	public void setAlertness(int alertness) { this.alertness = alertness; }
	public void setAthletics(int athletics) { this.athletics = athletics; }
	public void setBrawl(int brawl) { this.brawl = brawl; }
	public void setDodge(int dodge) { this.dodge = dodge; }
	public void setEmpathy(int empathy) { this.empathy = empathy; }
	public void setIntimidation(int intimidation) { this.intimidation = intimidation; }
	public void setLeadership(int leadership) { this.leadership = leadership; }
	public void setStreetwise(int streetwise) { this.streetwise = streetwise; }
	public void setSubterfuge(int subterfuge) { this.subterfuge = subterfuge; }
	public void setAnimalken(int animalken) { this.animalken = animalken; }
	public void setDrive(int drive) { this.drive = drive; }
	public void setEtiquette(int etiquette) { this.etiquette = etiquette; }
	public void setFirearms(int firearms) { this.firearms = firearms; }
	public void setMelee(int melee) { this.melee = melee; }
	public void setMusic(int music) { this.music = music; }
	public void setRepair(int repair) { this.repair = repair; }
	public void setSecurity(int security) { this.security = security; }
	public void setStealth(int stealth) { this.stealth = stealth; }
	public void setSurvival(int survival) { this.survival = survival; }
	public void setBureaucracy(int bureaucracy) { this.bureaucracy = bureaucracy; }
	public void setComputer(int computer) { this.computer = computer; }
	public void setFinance(int finance) { this.finance = finance; }
	public void setInvestigation(int investigation) { this.investigation = investigation; }
	public void setLaw(int law) { this.law = law; }
	public void setLinguistics(int linguistics) { this.linguistics = linguistics; }
	public void setMedicine(int medicine) { this.medicine = medicine; }
	public void setOccult(int occult) { this.occult = occult; }
	public void setPolitics(int politics) { this.politics = politics; }
	public void setScience(int science) { this.science = science; }
	public void setDiscipline1(String discipline1) { this.discipline1 = discipline1; }
	public void setDiscipline1val(int discipline1val) { this.discipline1val = discipline1val; }
	public void setDiscipline2(String discipline2) { this.discipline2 = discipline2; }
	public void setDiscipline2val(int discipline2val) { this.discipline2val = discipline2val; }
	public void setDiscipline3(String discipline3) { this.discipline3 = discipline3; }
	public void setDiscipline3val(int discipline3val) { this.discipline3val = discipline3val; }
	public void setDiscipline4(String discipline4) { this.discipline4 = discipline4; }
	public void setDiscipline4val(int discipline4val) { this.discipline4val = discipline4val; }
	public void setDiscipline5(String discipline5) { this.discipline5 = discipline5; }
	public void setDiscipline5val(int discipline5val) { this.discipline5val = discipline5val; }
	public void setBackground1(String background1) { this.background1 = background1; }
	public void setBackground1val(int background1val) { this.background1val = background1val; }
	public void setBackground2(String background2) { this.background2 = background2; }
	public void setBackground2val(int background2val) { this.background2val = background2val; }
	public void setBackground3(String background3) { this.background3 = background3; }
	public void setBackground3val(int background3val) { this.background3val = background3val; }
	public void setBackground4(String background4) { this.background4 = background4; }
	public void setBackground4val(int background4val) { this.background4val = background4val; }
	public void setBackground5(String background5) { this.background5 = background5; }
	public void setBackground5val(int background5val) { this.background5val = background5val; }
	public void setConscience(int conscience) { this.conscience = conscience; }
	public void setSelfcontrol(int selfcontrol) { this.selfcontrol = selfcontrol; }
	public void setCourage(int courage) { this.courage = courage; }
	public void setTrait1(String trait1) { this.trait1 = trait1; }
	public void setTrait1val(int trait1val) { this.trait1val = trait1val; }
	public void setTrait2(String trait2) { this.trait2 = trait2; }
	public void setTrait2val(int trait2val) { this.trait2val = trait2val; }
	public void setTrait3(String trait3) { this.trait3 = trait3; }
	public void setTrait3val(int trait3val) { this.trait3val = trait3val; }
	public void setTrait4(String trait4) { this.trait4 = trait4; }
	public void setTrait4val(int trait4val) { this.trait4val = trait4val; }
	public void setTrait5(String trait5) { this.trait5 = trait5; }
	public void setTrait5val(int trait5val) { this.trait5val = trait5val; }
	public void setWeapon1(String weapon1) { this.weapon1 = weapon1; }
	public void setWeapon1diff(int weapon1diff) { this.weapon1diff = weapon1diff; }
	public void setWeapon1dam(int weapon1dam) { this.weapon1dam = weapon1dam; }
	public void setWeapon2(String weapon2) { this.weapon2 = weapon2; }
	public void setWeapon2diff(int weapon2diff) { this.weapon2diff = weapon2diff; }
	public void setWeapon2dam(int weapon2dam) { this.weapon2dam = weapon2dam; }
	public void setWeapon3(String weapon3) { this.weapon3 = weapon3; }
	public void setWeapon3diff(int weapon3diff) { this.weapon3diff = weapon3diff; }
	public void setWeapon3dam(int weapon3dam) { this.weapon3dam = weapon3dam; }
	public void setHumanity(int humanity) { this.humanity = humanity; }
	public void setWillpower(int willpower) { this.willpower = willpower; }
	public void setWillpowercur(int willpowercur) { this.willpowercur = willpowercur; }
	public void setBloodpool(int bloodpool) { this.bloodpool = bloodpool; }
	public void setHealth(String health) { this.health = health; }
	public void setExperience(int experience) { this.experience = experience; }
	public void setExperiencecur(int experiencecur) { this.experiencecur = experiencecur; }
	public void setPhysicLeft(int PhysicLeft) { this.PHYSIC_LEFT = PhysicLeft; }
	public void setSocialLeft(int SocialLeft) { this.SOCIAL_LEFT = SocialLeft; }
	public void setMentalLeft(int MentalLeft) { this.MENTAL_LEFT = MentalLeft; }
	public void setTalentLeft(int TalentLeft) { this.TALENT_LEFT = TalentLeft; }
	public void setSkillLeft(int SkillLeft) { this.SKILL_LEFT = SkillLeft; }
	public void setKnowledgeLeft(int KnowledgeLeft) { this.KNOWLEDGE_LEFT = KnowledgeLeft; }
	public void setDisciplineLeft(int DisciplineLeft) { this.DISCIPLINE_LEFT = DisciplineLeft; }
	public void setBackgroundLeft(int BackgroundLeft) { this.BACKGROUND_LEFT = BackgroundLeft; }
	public void setVirtueLeft(int VirtueLeft) { this.VIRTUE_LEFT = VirtueLeft; }
	
	public boolean isValid() {
		if (PHYSIC_LEFT == 0 && SOCIAL_LEFT == 0 && MENTAL_LEFT == 0 &&
			TALENT_LEFT == 0 && SKILL_LEFT == 0 && KNOWLEDGE_LEFT == 0 &&
			DISCIPLINE_LEFT == 0 && BACKGROUND_LEFT == 0 && VIRTUE_LEFT == 0) {
				return true;
		}
		return false;
	}
	public int save(Context context, int user) {
		SQLiteDatabase db = (new DatabaseHelper(context)).getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("iduser", user);
		cv.put("charname",name);
		cv.put("nature",nature);
		cv.put("demeanor",demeanor);
		cv.put("clan",clan);
		cv.put("generation",generation);
		cv.put("haven",haven);
		cv.put("concept",concept);
		cv.put("strength",strength);
		cv.put("dexterity",dexterity);
		cv.put("stamina",stamina);
		cv.put("charisma",charisma);
		cv.put("manipulation",manipulation);
		cv.put("appearance",appearance);
		cv.put("perception",perception);
		cv.put("intelligence",intelligence);
		cv.put("wits",wits);
		cv.put("acting",acting);
		cv.put("alertness",alertness);
		cv.put("athletics",athletics);
		cv.put("brawl",brawl);
		cv.put("dodge",dodge);
		cv.put("empathy",empathy);
		cv.put("intimidation",intimidation);
		cv.put("leadership",leadership);
		cv.put("streetwise",streetwise);
		cv.put("subterfuge",subterfuge);
		cv.put("animalken",animalken);
		cv.put("drive",drive);
		cv.put("etiquette",etiquette);
		cv.put("firearms",firearms);
		cv.put("melee",melee);
		cv.put("music",music);
		cv.put("repair",repair);
		cv.put("security",security);
		cv.put("stealth",stealth);
		cv.put("survival",survival);
		cv.put("bureaucracy",bureaucracy);
		cv.put("computer",computer);
		cv.put("finance",finance);
		cv.put("investigation",investigation);
		cv.put("law",law);
		cv.put("linguistics",linguistics);
		cv.put("medicine",medicine);
		cv.put("occult",occult);
		cv.put("politics",politics);
		cv.put("science",science);
		cv.put("discipline1",discipline1);
		cv.put("discipline1val",discipline1val);
		cv.put("discipline2",discipline2);
		cv.put("discipline2val",discipline2val);
		cv.put("discipline3",discipline3);
		cv.put("discipline3val",discipline3val);
		cv.put("discipline4",discipline4);
		cv.put("discipline4val",discipline4val);
		cv.put("discipline5",discipline5);
		cv.put("discipline5val",discipline5val);
		cv.put("background1",background1);
		cv.put("background1val",background1val);
		cv.put("background2",background2);
		cv.put("background2val",background2val);
		cv.put("background3",background3);
		cv.put("background3val",background3val);
		cv.put("background4",background4);
		cv.put("background4val",background4val);
		cv.put("background5",background5);
		cv.put("background5val",background5val);
		cv.put("conscience",conscience);
		cv.put("selfcontrol",selfcontrol);
		cv.put("courage",courage);
		cv.put("trait1",trait1);
		cv.put("trait1val",trait1val);
		cv.put("trait2",trait2);
		cv.put("trait2val",trait2val);
		cv.put("trait3",trait3);
		cv.put("trait3val",trait3val);
		cv.put("trait4",trait4);
		cv.put("trait4val",trait4val);
		cv.put("trait5",trait5);
		cv.put("trait5val",trait5val);
		cv.put("weapon1",weapon1);
		cv.put("weapon1diff",weapon1diff);
		cv.put("weapon1dam",weapon1dam);
		cv.put("weapon2",weapon2);
		cv.put("weapon2diff",weapon2diff);
		cv.put("weapon2dam",weapon2dam);
		cv.put("weapon3",weapon3);
		cv.put("weapon3diff",weapon3diff);
		cv.put("weapon3dam",weapon3dam);
		cv.put("humanity",humanity);
		cv.put("willpower",willpower);
		cv.put("willpowercur",willpowercur);
		cv.put("bloodpool",bloodpool);
		cv.put("health",health);
		cv.put("experience",experience);
		cv.put("experiencecur",experiencecur);
        long ret = db.insert("tbchar_vampire","idchar",cv);
        db.close();
        return (int)(ret != -1 ? ret : 0);
	}
}
