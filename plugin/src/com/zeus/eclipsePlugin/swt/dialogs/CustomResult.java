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

package com.zeus.eclipsePlugin.swt.dialogs;

import com.zeus.eclipsePlugin.swt.dialogs.ZDialog.DialogOption;

/**
 * A result from a custom dialog with an input box.
 */
public class CustomResult
{
   private String input;
   private DialogOption option;
   
   /**
    * Store the entered input string and selected option in this class.
    */
   public CustomResult( String input, DialogOption option )
   {
      this.input = input;
      this.option = option;
   }

   /**
    * Get the value entered into the dialogs input (text) box
    * @return The entered value.
    */
   public String getInput()
   {
      return input;
   }

   /**
    * Get the option (button) selected by the user in the dialog
    * @return The selected option.
    */
   public DialogOption getOption()
   {
      return option;
   }
}
