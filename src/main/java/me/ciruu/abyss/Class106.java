package me.ciruu.abyss;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.jsgf.JSGFGrammar;
import edu.cmu.sphinx.jsgf.JSGFRuleGrammar;
import edu.cmu.sphinx.linguist.dictionary.TextDictionary;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import me.ciruu.abyss.Manager;

public class Class106
implements Runnable {
    boolean Field1761 = false;
    private Microphone Field1762;
    private ConfigurationManager Field1763;
    private Recognizer Field1764;
    private TextDictionary Field1765;
    private JSGFGrammar Field1766;
    private JSGFRuleGrammar Field1767;
    private volatile Thread Field1768 = null;
    private boolean Field1769 = false;
    private LinkedList Field1770;

    public Class106() {
        try {
            URL uRL = this.getClass().getResource("/assets/abyss/voice/config.xml");
            this.Field1763 = new ConfigurationManager(uRL);
            this.Field1764 = (Recognizer)this.Field1763.lookup("recognizer");
            this.Field1762 = (Microphone)this.Field1763.lookup("microphone");
            this.Field1765 = (TextDictionary)this.Field1763.lookup("dictionary");
            this.Field1766 = (JSGFGrammar)this.Field1763.lookup("jsgfGrammar");
            this.Field1766.allocate();
            this.Field1767 = this.Field1766.getRuleGrammar();
            this.Field1770 = new LinkedList();
        }
        catch (IOException iOException) {
            Manager.logger.error("Cannot load speech recognizer:");
            Manager.logger.error(iOException.toString());
        }
        catch (PropertyException propertyException) {
            Manager.logger.error("Cannot configure speech recognizer:");
            Manager.logger.error(propertyException.toString());
        }
    }

    public boolean isWord(String string) {
        return this.Field1765.getWord(string) != null;
    }

    @Override
    public void run() {
        Manager.logger.debug("Recognition thread starting");
        while (this.Field1769) {
            String string;
            Result result = this.Field1764.recognize();
            if (!this.Field1761 || result == null || (string = result.getBestFinalResultNoFiller()).equals("")) continue;
            this.Field1770.addLast(string);
        }
        Manager.logger.debug("Recognition thread finished");
    }

    public int getQueueSize() {
        return this.Field1770.size();
    }

    public String popString() {
        if (this.getQueueSize() > 0) {
            return (String)this.Field1770.removeFirst();
        }
        return "";
    }

    public boolean isEnabled() {
        return this.Field1762.isRecording();
    }

    public void setEnabled(boolean bl) {
        if (bl) {
            this.Field1764.allocate();
            Manager.logger.debug("Starting microphone...");
            boolean bl2 = this.Field1762.startRecording();
            Manager.logger.debug("Microphone on");
            if (!bl2) {
                Manager.logger.warn("Cannot initialize microphone. Speech recognition disabled.");
                return;
            }
            if (null != this.Field1768) {
                Manager.logger.warn("New recognition thread being created before the previous one finished.");
            }
            this.Field1768 = new Thread((Runnable)this, "Recognition thread");
            this.Field1769 = true;
            this.Field1768.start();
        } else {
            Manager.logger.debug("Stopping microphone...");
            this.Field1762.stopRecording();
            Manager.logger.debug("Microphone off");
            this.Field1769 = false;
            while (this.Field1768 != null && this.Field1768.isAlive()) {
                Manager.logger.debug("Waiting for recognition thread to die...");
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException interruptedException) {}
            }
            this.Field1768 = null;
            this.Field1762.clear();
            this.Field1764.deallocate();
            Manager.logger.debug("Clearing recognized string queue");
            this.Field1770.clear();
        }
    }

    public void destroy() {
        this.setEnabled(false);
        this.Field1764.deallocate();
    }

    public LinkedList getRecognizedStringQueue() {
        return this.Field1770;
    }
}
