package xyz.lysean.jenkinsci.orchly

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import hudson.Extension
import hudson.Launcher
import hudson.model.AbstractBuild
import hudson.model.AbstractProject
import hudson.model.Action
import hudson.model.BuildListener
import hudson.tasks.BuildStepDescriptor
import hudson.tasks.Builder
import org.apache.commons.lang.StringUtils
import org.kohsuke.stapler.DataBoundConstructor

/**
 * orchly-plugin: a plugin task build system, usage yaml configure task flow.
 *
 * Pipeline -> stages.
 *
 * Stages -> tasks
 *
 * config syntax:
 *
 * # fileName: Orchlyfile.yml
 *
 * application:
 *   name: sample
 *
 * stages:
 *   build:
 *     tasks:
 *       - customtask:
 *           k: v
 *       - vscompile:
 *           k: v
 *
 * pipelines:
 *   test:
 *     - build
 *     - deploy
 *     - test
 *   testRollback:
 *     - deploy
 */
@CompileStatic
@Slf4j
class OrchlyBuilder extends Builder implements Serializable {


    private final String confFilePath;

    @DataBoundConstructor
    OrchlyBuilder(String confFilePath) {
        this.confFilePath = confFilePath
    }

    public String getConfFilePath() {
        if (StringUtils.isBlank(confFilePath)) {
            return Constants.ORCHLYFILE_DOT_YAML
        }

        return confFilePath
    }

    @Override
    boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {

        true
    }


    @Extension
    final static class DescriptorImpl extends BuildStepDescriptor<Builder> {

        @Override
        boolean isApplicable(Class<? extends AbstractProject> jobType) {
            true
        }

        @Override
        String getDisplayName() {
            Messages.orchly_description
        }
    }
}
