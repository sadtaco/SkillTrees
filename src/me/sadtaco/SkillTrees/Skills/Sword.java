package me.sadtaco.SkillTrees.Skills;

import java.util.HashMap;

public class Sword {
	public HashMap<String, Skill> map = new HashMap<String, Skill>();
	public Sword(){
		Skill blank3 = new Skill().setName("Blank3").setType("passive").setRow(4).setCol(3);
		Skill blank2 = new Skill().setName("Blank2").setType("active").setRow(4).setCol(0);
		Skill blank1 = new Skill().setName("Blank1").setType("passive").setRow(3).setCol(3);
		Skill triforce = new Skill().setName("Triforce").setType("passive").setRow(3).setCol(2);
		Skill essence_of_fire = new Skill().setName("Essence of Storm").setType("passive").setRow(3).setCol(1).addChild("Triforce");
		Skill essence_of_storm = new Skill().setName("Essence of Storm").setType("passive").setRow(2).setCol(2).addChild("Triforce");
		Skill essence_of_ice = new Skill().setName("Essence of Ice").setType("passive").setRow(2).setCol(1).addChild("Triforce");
		Skill fencing = new Skill().setName("Fencing").setType("passive").setRow(1).setCol(3);
		Skill rend = new Skill().setName("Rend").setType("passive").setRow(1).setCol(1);
		Skill hilt_bash = new Skill().setName("Hilt Bash").setType("active").setRow(1).setCol(0);
		Skill impale = new Skill().setName("Impale").setType("active").setRow(0).setCol(0).addChild("Rend").addChild("Hilt Bash");
		Skill basic_swordsmanship = new Skill().setName("Basic Swordsmanship").setType("passive").setRow(0).setCol(3);
		map.put("Impale", impale );
		map.put("Basic Swordsmanship", basic_swordsmanship );
		map.put("Rend", rend );
		map.put("Hilt Bash", hilt_bash);
		map.put("Fencing", fencing);
		map.put("Essence of Ice", essence_of_ice);
		map.put("Essence of Storm", essence_of_storm);
		map.put("Essence of Fire", essence_of_fire);
		map.put("Triforce", triforce);
		map.put("Blank1", blank1);
		map.put("Blank2", blank2);
		map.put("Blank3", blank3);
	}
	public Skill getSkill(String skillName) {
		return map.get(skillName);
	}
}