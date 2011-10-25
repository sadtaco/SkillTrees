package me.sadtaco.SkillTrees.Skills;

import java.util.Map.Entry;

import me.sadtaco.SkillTrees.SkillTrees;
import me.sadtaco.SkillTrees.gui.SkillSlot;

import org.getspout.spoutapi.gui.Container;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class Tree {
	public Container box;
	public Sword swordSkills;
	static final int numRows = 5;
	static final int numCols = 4;
	
	public Skill[][] skills = new Skill[numRows][numCols];
	public SkillSlot[][] skillSlots = new SkillSlot[numRows][numCols];
	
	public Tree(GenericPopup skillTreePopup, SkillTrees plugin){
		box = new GenericContainer();
		box.setLayout(ContainerType.VERTICAL);
		box.setAnchor(WidgetAnchor.TOP_CENTER);
		box.setWidth(168).setHeight(210); //This is taller than it should be so the top skills align right to the top, and bottom ones to the bottom, instead of having a big gap
		box.setX(-84).setY(30);
		box.setPriority(RenderPriority.High);
		box.setAuto(true);
		
		swordSkills = new Sword();
		
		for (Entry<String, Skill> entry : swordSkills.map.entrySet()) {
		    //String key = entry.getKey();
		    Skill skill = entry.getValue();
		    //System.out.println( key + " " + skill );
		    int row = skill.getRow();
		    int col = skill.getCol();
		    skills[row][col] = skill;
		}
		for( int row = 0; row < numRows; row++ ){
			Container rowBox = new GenericContainer();
			rowBox.setLayout(ContainerType.HORIZONTAL);
			rowBox.setWidth(300).setHeight(38);
            for( int col = 0; col < numCols; col++ ){
            	if( skills[row][col] == null)
            		skills[row][col] = new Skill();
            	Skill skill = skills[row][col];
            	skillSlots[row][col] = new SkillSlot(rowBox).setName(skill.getName()).setType(skill.getType());
            }
            box.addChild(rowBox);
		}
		for( int row = 0; row < numRows; row++ ){
            for( int col = 0; col < numCols; col++ ){
            	SkillSlot skillSlot = skillSlots[row][col];
            	Skill skill = skills[row][col];
            	String[] children = skill.getChildren();
            	skillSlots[row][col].arrowToR();
            	for( int i = 0; i < children.length; i++  ){
            		Skill childSkill = swordSkills.getSkill(children[i]);
            		System.out.println(skill.getName() + " has child " + childSkill.getName());
            		int childRow = childSkill.getRow();
            		int childCol = childSkill.getCol();
            		System.out.println( "childRow:"+childRow + " row:"+row );
            		System.out.println( "childCol:"+childCol + " col:"+col );
            		System.out.println( skillSlot);
            		if( childCol == col && childRow == row+1 ){
            			System.out.println("ToB");
            			skillSlot.arrowToB();
            		}
            		if( childCol == col+1 && childRow == row ){
            			System.out.println("ToR");
            			skillSlot.arrowToR();
            		}
            		if( childCol == col-1 && childRow == row ){
            			System.out.println("ToL");
            			skillSlot.arrowToL();
            		}
            		if( childCol == col+1 && childRow == row+1 ){
            			System.out.println("ToBR");
            			skillSlot.arrowToBR();
            		}
            		if( childCol == col-1 && childRow == row+1){
            			skillSlot.arrowToBL();
            		}
            		int botIterations = childCol - col;
            		int rightIterations = childRow - row;
            		if( botIterations > 1 ){
            			for( int ii = 0; ii < botIterations; ii++ ){
            				SkillSlot lowerSkillSlot = skillSlots[ii][col];
            				if( ii < botIterations){
            					lowerSkillSlot.arrowToLongB();
            				}
            				else {
            					lowerSkillSlot.arrowToB();
            				}
            			}
            		}
            		if( rightIterations > 1 ){
            			//
            		}
            			
            	}
            }
        }
		
		skillTreePopup.attachWidget(plugin, box);
	}
}
