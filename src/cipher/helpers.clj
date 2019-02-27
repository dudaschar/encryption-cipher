(ns cipher.helpers)

(defn to-int
  "Receive an lowercase letter and return your position on alphabet"
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))


(defn to-char
  [number]
  (let [ascii-a (int \a) value-ascii (+ number ascii-a)]
    (char value-ascii)))


(defn shift
  [letter key]
  (let [ position-value (+ (to-int letter) key)
        new-position (mod position-value 26)]
    (to-char new-position)))

(defn get-letters
  [text]
  (let [lower-case-text (clojure.string/lower-case text)]
    (apply str (filterv #(Character/isLetter %) lower-case-text))))

(defn encrypt-letter
  [letter letter-key]
  (let [new-letter (mod (+ (to-int letter) (to-int letter-key)) 26)]
    (to-char new-letter)))

(defn decrypt-letter
  [letter letter-encrypt]
  (let [new-letter (mod (- (to-int letter-encrypt) (to-int letter)) 26)]
    (to-char new-letter))
  )