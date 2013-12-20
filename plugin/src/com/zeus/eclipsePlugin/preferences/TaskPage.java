/*******************************************************************************
 * Copyright (C) 2013 Riverbed Technology, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Riverbed Technology - Main Implementation
 ******************************************************************************/

package com.zeus.eclipsePlugin.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.zeus.eclipsePlugin.PreferenceManager;
import com.zeus.eclipsePlugin.ZDebug;
import com.zeus.eclipsePlugin.consts.Preference;
import com.zeus.eclipsePlugin.swt.SWTUtil;
import com.zeus.eclipsePlugin.swt.TaskControl;

/**
 * Allows changing the task markers used by the TrafficScript editor.
 */
public class TaskPage extends ZXTMPreferencePage
{
   private TaskControl taskControl;

   /**
    * Creates the contents of the page. Uses a TaskControl to edit task tags.
    */
   /* Override */
   protected Control createContents( Composite parent )
   {
      ZDebug.print( 4, "createControl( ", parent, " )" );
      Composite mainComposite = SWTUtil.createGridLayoutComposite( parent, 1 );
      SWTUtil.gridDataFillHorizontal( mainComposite );
      SWTUtil.removeLayoutMargins( mainComposite.getLayout() );
      
      String taskTags = PreferenceManager.getPreference( Preference.TASK_TAGS );
      
      taskControl = new TaskControl( mainComposite, taskTags );
      SWTUtil.gridDataFillHorizontal( taskControl.getComposite() );
            
      mainComposite.pack();
      mainComposite.layout();
      
      return mainComposite;
   }
   
   /**
    * Gets the default task tags string and updates the TaskControl.
    */
   /* Override */
   protected void performDefaults()
   {
      taskControl.setTaskString( Preference.TASK_TAGS.getDefault().toString() );
   }

   /**
    * Get the updated task string from the TaskControl and set the preference.
    */
   /* Override */
   public boolean performOk()
   {
      PreferenceManager.setPreference(
         Preference.TASK_TAGS, taskControl.getTaskString()          
      );
      
      return true;
   }


}
