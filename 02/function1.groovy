#!/usr/bin/groovy

def gamesWithAcceptableBalls = []
def gameId, handfuls

def maxValues = [
  red: 12,
  green: 13,
  blue: 14
]

new File('input.txt').eachLine { game ->

  gameId = game.split(':').first().replace('Game ','').toInteger()
  gamesWithAcceptableBalls.add(gameId)
  handfuls = game.split(':').last().split(';')

  // loop through each handful and check for max value
  handfuls.each { handful ->
    handful.split(',').each { balls ->
      maxValues.each { colour, max ->
        if (balls.contains(colour)) {
          if (balls.findAll(/\d+/)*.toInteger()[0] > max) {
            gamesWithAcceptableBalls = gamesWithAcceptableBalls.minus(gameId)
          }
        }
      }
    }
  }

}

// dedupe values and print result
println(gamesWithAcceptableBalls.unique().sum())
