/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package de.hybris.platform.cuppytrailcockpit.components.navigationarea;

import de.hybris.platform.cockpit.components.navigationarea.DefaultNavigationAreaModel;
import de.hybris.platform.cockpit.session.impl.AbstractUINavigationArea;

import de.hybris.platform.cuppytrailcockpit.session.impl.CuppytrailcockpitNavigationArea;


/**
 * Cuppytrailcockpit navigation area model.
 */
public class CuppytrailcockpitNavigationAreaModel extends DefaultNavigationAreaModel
{
	public CuppytrailcockpitNavigationAreaModel()
	{
		super();
	}

	public CuppytrailcockpitNavigationAreaModel(final AbstractUINavigationArea area)
	{
		super(area);
	}

	@Override
	public CuppytrailcockpitNavigationArea getNavigationArea()
	{
		return (CuppytrailcockpitNavigationArea) super.getNavigationArea();
	}
}
