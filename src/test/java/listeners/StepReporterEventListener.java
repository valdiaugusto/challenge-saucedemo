package listeners;

import base.BaseSteps;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;

public class StepReporterEventListener extends BaseSteps implements StepLifecycleListener {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StepReporterEventListener.class));

    @Override
    public void beforeStepStart(StepResult result) {
        LOGGER.info("Step a completar: " + result.getName());
    }

    @Override
    public void afterStepUpdate(StepResult result) {
        LOGGER.info("Step completado: " + result.getName());
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            screenshot();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
