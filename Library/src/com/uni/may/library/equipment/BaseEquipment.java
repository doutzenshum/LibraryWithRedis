package com.uni.may.library.equipment;

import com.uni.may.library.command.IEquCommand;

public abstract class BaseEquipment implements IEquCommand {
	
	protected String id;
	
	protected String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id + "-" + this.name;
	}

}
