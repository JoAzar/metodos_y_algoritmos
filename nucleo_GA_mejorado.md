import random

# ========== CONFIGURACIÓN ==========
TARGET = "semilla que regresa desde el futuro"
WORD_POOL = ["semilla", "regresa", "desde", "el", "futuro", "origen", "nodo", "abuelo", "nieto", "ley", "código", "gravedad"]
POP_SIZE = 50
MAX_GENERATIONS = 500
TOURNAMENT_SIZE = 5
MUTATION_RATE_BASE = 0.4

# ========== UTILIDADES ==========
def fitness(phrase):
    return sum(1 for a, b in zip(phrase, TARGET.split()) if a == b)

def random_phrase():
    return [random.choice(WORD_POOL) for _ in TARGET.split()]

def mutate(phrase, mutation_rate):
    return [word if random.random() > mutation_rate else random.choice(WORD_POOL) for word in phrase]

def crossover(parent1, parent2):
    return [random.choice(pair) for pair in zip(parent1, parent2)]

def tournament_selection(population, scores):
    tournament = random.sample(list(zip(population, scores)), TOURNAMENT_SIZE)
    return max(tournament, key=lambda x: x[1])[0]

# ========== ALGORITMO ==========
def genetic_algorithm():
    population = [random_phrase() for _ in range(POP_SIZE)]
    best_overall = None
    best_fitness = -1
    stagnation = 0

    for generation in range(MAX_GENERATIONS):
        scores = [fitness(p) for p in population]
        avg_fitness = sum(scores) / len(scores)
        mutation_rate = MUTATION_RATE_BASE * (1 - (avg_fitness / len(TARGET.split())))

        best_idx = scores.index(max(scores))
        if scores[best_idx] > best_fitness:
            best_overall = population[best_idx]
            best_fitness = scores[best_idx]
            stagnation = 0
        else:
            stagnation += 1

        if best_fitness == len(TARGET.split()):
            break  # solución encontrada

        new_population = []
        for _ in range(POP_SIZE):
            parent1 = tournament_selection(population, scores)
            parent2 = tournament_selection(population, scores)
            child = crossover(parent1, parent2)
            child = mutate(child, mutation_rate)
            new_population.append(child)

        # memoria: reinyectar mejor individuo si hay estancamiento
        if stagnation >= 20:
            new_population[random.randint(0, POP_SIZE-1)] = best_overall[:]
            stagnation = 0

        population = new_population

    return best_overall, best_fitness, generation

# ========== EJECUCIÓN ==========
if __name__ == "__main__":
    result, score, gen = genetic_algorithm()
    print(f"🔍 Resultado: {' '.join(result)}")
    print(f"🎯 Fitness: {score}/{len(TARGET.split())}")
    print(f"🧬 Generaciones: {gen}")