package com.massivecraft.vampire.cmd;

import org.bukkit.entity.Player;

import com.massivecraft.mcore1.cmd.VisibilityMode;
import com.massivecraft.vampire.*;
import com.massivecraft.vampire.config.Lang;


public class CmdCure extends VCommand
{
	public CmdCure()
	{
		this.addAliases("cure");

		requiredArgs.add("playername");
		
		this.setDesc("cure a vampire");
		this.setVisibilityMode(VisibilityMode.SECRET);
		
		this.setDescPermission(Permission.COMMAND_CURE.node);
	}
	
	@Override
	public void perform()
	{
		Player you = this.argAs(0, Player.class, "match");
		if (you == null) return;
		VPlayer vyou = VPlayers.i.get(you);
		vyou.cureVampirism();
		this.msg(Lang.xWasCured, you.getDisplayName());
	}
}