lineas = [""] * 10

def listar():
    for i, l in enumerate(lineas, 1):
        print(i, l)

def editar(n, texto):
    if 1 <= n <= 10:
        lineas[n-1] = texto

def borrar(n):
    if 1 <= n <= 10:
        lineas[n-1] = ""

def insertar(n, texto):
    if 1 <= n <= 10:
        lineas.insert(n-1, texto)
        lineas.pop()

def main():
    while True:
        cmd = input("> ").strip()
        if cmd == "q":
            break
        if cmd == "l":
            listar()
        elif cmd.startswith("e "):
            n, t = cmd.split(" ", 2)[1:]
            editar(int(n), t)
        elif cmd.startswith("d "):
            borrar(int(cmd.split()[1]))
        elif cmd.startswith("i "):
            n, t = cmd.split(" ", 2)[1:]
            insertar(int(n), t)

if __name__ == "__main__":
    main()