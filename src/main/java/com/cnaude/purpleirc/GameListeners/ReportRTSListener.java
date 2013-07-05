/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.GameListeners;

import com.cnaude.purpleirc.PurpleIRC;
import com.nyancraft.reportrts.data.HelpRequest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author cnaude
 */
public class ReportRTSListener implements Listener {

    private final PurpleIRC plugin;

    public ReportRTSListener(PurpleIRC plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onReportCreateEvent(HelpRequest request) {
        for (String botName : plugin.ircBots.keySet()) {
            if (plugin.botConnected.get(botName)) {
                plugin.ircBots.get(botName).reportRTSNotify(request);
            }
        }
    }
}