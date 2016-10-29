package com.obscured.phonegap.build;

import com.obscured.phonegap.build.common.PhonegapAction;
import com.obscured.phonegap.build.common.Utils;
import com.obscured.phonegap.build.common.Wrapper;
import com.obscured.phonegap.build.models.App;
import org.apache.commons.cli.*;

import java.util.Map;

public class Cli {

	private static Options options;
	private static CommandLine cmd;

	public static void main(String[] args) throws Exception {

		buildOptions(args);
		processOptions();
	}

	private static void buildOptions(String[] args) throws ParseException {
		options = new Options();
		Option help = Option.builder("h")
		                    .longOpt("help")
		                    .desc("Print this message")
		                    .build();
		Option user = Option.builder("u")
		                    .hasArg()
		                    .longOpt("user")
		                    .desc("The username for authorization to the Phonegap Build")
		                    .build();
		Option password = Option.builder("p")
		                        .hasArg()
		                        .longOpt("password")
		                        .desc("The password for authorization to the Phonegap Build")
		                        .build();
		Option token = Option.builder("t")
		                     .hasArg()
		                     .longOpt("token")
		                     .desc("The token for authorization to the Phonegap Build")
		                     .build();
		Option opt = Option.builder("D")
		                   .argName("property=value")
		                   .hasArgs()
		                   .numberOfArgs(2)
		                   .valueSeparator('=')
		                   .desc("Use value for given property")
		                   .build();

		options.addOption(help);
		options.addOption(user);
		options.addOption(password);
		options.addOption(token);
		options.addOption(opt);

		CommandLineParser parser = new DefaultParser();
		cmd = parser.parse(options, args);
	}

	private static void processOptions() {
		if (cmd.hasOption("h")) {
			printHelp();
		} else if (cmd.hasOption("D")) {
			String[] values = cmd.getOptionValues("D");
			Map<String, String> opts = Utils.OptionsToMap(values);
			opts.put("user", cmd.getOptionValue("u"));
			opts.put("password", cmd.getOptionValue("p"));
			handleOptions(opts);
		} else {
			System.out.println("No options were supplied");
		}
	}

	private static void handleOptions(Map<String, String> opts) {
		// for now only option is update
		if (opts.containsKey("user") && opts.containsKey("password") &&
		    opts.containsKey("id") && opts.containsKey("action") &&
		    opts.get("action").equalsIgnoreCase(PhonegapAction.UpdateAppById.toString())) {
			Wrapper wrapper = new Wrapper(opts.get("user"), opts.get("password"));
			App app = wrapper.updateRepoApp(opts.get("id"));
			if (app != null) {
				System.out.println(String.format("App %s is currently being updated", app.getId()));
			} else {
				System.out.println(String.format("App %s was not updated", opts.get("id")));
			}
		} else {
			System.out.println("Please supply required options.  Currently only update action is handled");
		}
	}

	private static void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("cli", options);
	}
}
