import rpyc

conn = rpyc.connect('localhost', 18861)

result = conn.root.add(5, 3)
print(f"Resultado da adição: {result}")

conn.close()
