/*
 * @author     ucchy
 * @license    GPLv3
 * @copyright  Copyright ucchy 2013
 */
package jp.ucchy.csc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * カスタムsayコマンド
 * @author ucchy
 */
public class CustomSayCommand extends JavaPlugin {

    /**
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {
        saveDefaultConfig();
    }

    /**
     * @see org.bukkit.plugin.java.JavaPlugin#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        StringBuilder str = new StringBuilder();
        str.append(getConfig().getString("sayPrefix", ""));
        for ( String a : args ) {
            str.append(a + " ");
        }
        String result = str.toString().trim();
        Bukkit.broadcastMessage(replaceColorCode(result));
        return true;
    }

    /**
     * 文字列内のカラーコードを置き換えする
     * @param source 置き換え元の文字列
     * @return 置き換え後の文字列
     */
    private String replaceColorCode(String source) {
        return source.replaceAll("&([0-9a-fk-or])", "\u00A7$1");
    }
}
