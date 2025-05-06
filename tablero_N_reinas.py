def colocar_bloque(tablero, base_fila, base_col, solucion_8):
    for i, col in enumerate(solucion_8):
        fila = base_fila + i
        columna = base_col + col - 1
        if fila < len(tablero) and columna < len(tablero):
            tablero[fila][columna] = 'Q'

def imprimir_tablero(tablero):
    for fila in tablero:
        print(' '.join(fila))

def generar_tablero_n_reinas(n):
    if n % 8 != 0:
        raise ValueError("Este método solo funciona con tableros de tamaño múltiplo de 8.")

    solucion_8 = [1, 5, 8, 6, 3, 7, 2, 4]
    bloques = n // 8
    tablero = [['.' for _ in range(n)] for _ in range(n)]

    for i in range(bloques):
        for j in range(bloques):
            colocar_bloque(tablero, i * 8, j * 8, solucion_8)

    return tablero

tablero = generar_tablero_n_reinas(16)
imprimir_tablero(tablero)
