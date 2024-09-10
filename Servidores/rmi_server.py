import rpyc

class MyService(rpyc.Service):
    def on_connect(self, conn):
        pass

    def on_disconnect(self, conn):
        pass

    def exposed_add(self, x, y):
        return x + y

from rpyc.utils.server import ThreadedServer
server = ThreadedServer(MyService, port=18861)
print("Servidor RMI está rodando...")
server.start()
