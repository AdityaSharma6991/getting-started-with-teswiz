package com.znsio.e2e.screen;

import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import java.util.List;

import static com.znsio.e2e.runner.Runner.fetchDriver;
import static com.znsio.e2e.runner.Runner.fetchEyes;

public abstract class CartScreen {
    private static final String SCREEN_NAME = LoginScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static CartScreen get() {
        Driver driver = fetchDriver(Thread.currentThread().getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread().getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = fetchEyes(Thread.currentThread().getId());
        switch (platform) {
            case web:
                return new CartScreenWeb(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.platform);
    }

    public abstract boolean verifyContentAdd();

    public abstract boolean verifyContentRemove();

    public abstract String getCartCounter();

}