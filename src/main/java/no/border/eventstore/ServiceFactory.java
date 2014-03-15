package no.border.eventstore;

import no.no.borber.command.CommandHandler;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private CommandHandler commandHandler;
    private Handlekurv handlekurv;

    private ServiceFactory() {
        EventStore eventStore = new EventStore();
        commandHandler = new CommandHandler(eventStore);
        handlekurv = new Handlekurv();
        eventStore.subscribe(handlekurv);
    }

    public static CommandHandler commandHandler() {
        return instance.commandHandler;
    }

    public static Handlekurv handlekurv() {
        return instance.handlekurv;
    }
}
