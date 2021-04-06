/*
 * SPDX-FileCopyrightText: 2020 Aniket Kumar <anikketkumar786@gmail.com>
 *
 * SPDX-License-Identifier: GPL-2.0-only OR GPL-3.0-only OR LicenseRef-KDE-Accepted-GPL
 */
package org.pear.pairdrop.UserInterface.List;

import org.pear.pairdrop.Plugins.Plugin;

public class SetDefaultAppPluginListItem extends SmallEntryItem {

    public interface Action {
        void action(Plugin plugin);
    }

    public SetDefaultAppPluginListItem(Plugin plugin, String displayName, SetDefaultAppPluginListItem.Action action) {
        super(displayName,  (view) -> action.action(plugin));
    }
}