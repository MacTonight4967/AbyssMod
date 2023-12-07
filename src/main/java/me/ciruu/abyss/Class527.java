package me.ciruu.abyss;

import me.ciruu.abyss.Class99;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.combat.AutoArmor;
import me.ciruu.abyss.modules.combat.AutoCrystal;
import me.ciruu.abyss.modules.combat.AutoTrap;
import me.ciruu.abyss.modules.combat.Burrow;
import me.ciruu.abyss.modules.combat.HoleFiller;
import me.ciruu.abyss.modules.combat.OffHand;
import me.ciruu.abyss.modules.combat.Surround;

public class Class527
extends Class99 {
    private boolean Field1961 = false;

    public Class527(String string) {
        super(string);
    }

    public void Method2361(String[] stringArray) {
        if (stringArray[0] != null) {
            this.Field1961 = stringArray[0].equalsIgnoreCase("enable");
        }
        if (stringArray[1] != null) {
            switch (stringArray[1]) {
                case "crystal": {
                    this.Method2362(this.Field1961);
                    break;
                }
                case "surround": {
                    this.Method2363(this.Field1961);
                    break;
                }
                case "offhand": {
                    this.Method2364(this.Field1961);
                    break;
                }
                case "trap": {
                    this.Method2365(this.Field1961);
                    break;
                }
                case "armor": {
                    this.Method2366(this.Field1961);
                    break;
                }
                case "fill": {
                    this.Method2367(this.Field1961);
                    break;
                }
                case "burrow": {
                    this.Method2368(this.Field1961);
                    break;
                }
            }
        }
    }

    public boolean Method2369(String[] stringArray) {
        return stringArray[0].equalsIgnoreCase("enable") || stringArray[0].equalsIgnoreCase("disable");
    }

    private void Method2368(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(Burrow.class)) {
            ((Burrow)Manager.moduleManager.getModuleByClass(Burrow.class)).Method2370();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(Burrow.class)) {
            ((Burrow)Manager.moduleManager.getModuleByClass(Burrow.class)).Method2370();
        }
    }

    private void Method2367(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(HoleFiller.class)) {
            ((HoleFiller)Manager.moduleManager.getModuleByClass(HoleFiller.class)).Method1092();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(HoleFiller.class)) {
            ((HoleFiller)Manager.moduleManager.getModuleByClass(HoleFiller.class)).Method1092();
        }
    }

    private void Method2366(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(AutoArmor.class)) {
            ((AutoArmor)Manager.moduleManager.getModuleByClass(AutoArmor.class)).Method2371();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(AutoArmor.class)) {
            ((AutoArmor)Manager.moduleManager.getModuleByClass(AutoArmor.class)).Method2371();
        }
    }

    private void Method2362(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(AutoCrystal.class)) {
            ((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Method2372();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(AutoCrystal.class)) {
            ((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Method2372();
        }
    }

    private void Method2365(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(AutoTrap.class)) {
            ((AutoTrap)Manager.moduleManager.getModuleByClass(AutoTrap.class)).Method2373();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(AutoTrap.class)) {
            ((AutoTrap)Manager.moduleManager.getModuleByClass(AutoTrap.class)).Method2373();
        }
    }

    private void Method2364(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(OffHand.class)) {
            ((OffHand)Manager.moduleManager.getModuleByClass(OffHand.class)).Method2374();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(OffHand.class)) {
            ((OffHand)Manager.moduleManager.getModuleByClass(OffHand.class)).Method2374();
        }
    }

    private void Method2363(boolean bl) {
        if (bl && !Manager.moduleManager.isModuleEnabled(Surround.class)) {
            ((Surround)Manager.moduleManager.getModuleByClass(Surround.class)).Method2105();
        } else if (!bl && Manager.moduleManager.isModuleEnabled(Surround.class)) {
            ((Surround)Manager.moduleManager.getModuleByClass(Surround.class)).Method2105();
        }
    }
}
