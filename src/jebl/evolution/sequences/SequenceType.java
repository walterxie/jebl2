/*
 * SequenceType.java
 *
 * (c) 2002-2005 JEBL Development Core Team
 *
 * This package may be distributed under the
 * Lesser Gnu Public Licence (LGPL)
 */

package jebl.evolution.sequences;

import java.util.List;

/**
 * Interface for sequences data types.
 *
 * @author Andrew Rambaut
 * @author Alexei Drummond
 * @version $Id: SequenceType.java 849 2007-12-06 00:10:14Z twobeers $
 */
public interface SequenceType {

    /**
     * Get number of states including ambiguous states
     *
     * @return number of states
     */
    int getStateCount();

    /**
     * Get a list of states ordered by their indices.
     *
     * @return a list of states
     */
    List<? extends State> getStates();

    /**
     * Get number of canonical states
     *
     * @return number of states
     */
    int getCanonicalStateCount();

    /**
     * Get a list of canonical states ordered by their indices.
     *
     * @return a list of states
     */
    List<? extends State> getCanonicalStates();

    /**
     * Get state corresponding to a string code
     *
     * @param code a string code
     * @return the state with the given code, or null if there is no such state
     */
    State getState(String code);

    /**
     * Get state whose code is the one-character string consisting only of code.
     *
     * @param code
     * @return the state with the given code, or null if there is no such state
     */
    State getState(char code);

    /**
     * @return the length, in characters, of a state, when encoded as a string.
     *         i.e. 1 for Nucleotides and AminoAcids and 3 for Codons.
     */
    int getCodeLength();

    /**
     * Get state corresponding to a state index
     *
     * @param index a state index
     * @return the state
     */
    State getState(int index);

    /**
     * Get state corresponding to an unknown
     *
     * @return the state
     */
    State getUnknownState();

    /**
     * Get state corresponding to a gap
     *
     * @return state
     */
    State getGapState();

    /**
     * @return true if this state is an unknown state
     */
    boolean isUnknown(State state);

    /**
     * @return true if this state is a gap
     */
    boolean isGap(State state);

    /**
     * name of data type
     *
     * @return string describing the data type
     */
    String getName();

    /**
     * @return datatype inside a nexus characters block, if any.
     */
    String getNexusDataType();

    /**
     * Converts a string of state codes into an array of State objects for this SequenceType
     *
     * @param sequenceString
     * @return the State array
     */
    State[] toStateArray(String sequenceString);

    /**
     * Converts an array of state indices into an array of State objects for this SequenceType
     *
     * @param indexArray
     * @return the State array
     */
    State[] toStateArray(byte[] indexArray);

    public static final SequenceType NUCLEOTIDE = new SequenceType() {
        public int getStateCount() {
            return Nucleotides.getStateCount();
        }

        public List<State> getStates() {
            return Nucleotides.getStates();
        }

        public int getCanonicalStateCount() {
            return Nucleotides.getCanonicalStateCount();
        }

        public List<NucleotideState> getCanonicalStates() {
            return Nucleotides.getCanonicalStates();
        }

        public State getState(String code) {
            return Nucleotides.getState(code);
        }

        public State getState(char code) {
            return Nucleotides.getState(code);
        }

        public int getCodeLength() {
            return 1;
        }

        public State getState(int index) {
            return Nucleotides.getState(index);
        }

        public State getUnknownState() {
            return Nucleotides.getUnknownState();
        }

        public State getGapState() {
            return Nucleotides.getGapState();
        }

        public boolean isUnknown(State state) {
            return Nucleotides.isUnknown((NucleotideState) state);
        }

        public boolean isGap(State state) {
            return Nucleotides.isGap((NucleotideState) state);
        }

        public String getName() {
            return Nucleotides.NAME;
        }

        public String getNexusDataType() {
            return "dna";
        }

        public State[] toStateArray(String sequenceString) {
            return Nucleotides.toStateArray(sequenceString);
        }

        public State[] toStateArray(byte[] indexArray) {
            return Nucleotides.toStateArray(indexArray);
        }

        public String toString() {
            return getName();
        }
    };

    public static final SequenceType AMINO_ACID = new SequenceType() {
        public int getStateCount() {
            return AminoAcids.getStateCount();
        }

        public List<AminoAcidState> getStates() {
            return AminoAcids.getStates();
        }

        public int getCanonicalStateCount() {
            return AminoAcids.getCanonicalStateCount();
        }

        public List<State> getCanonicalStates() {
            return AminoAcids.getCanonicalStates();
        }

        public State getState(String code) {
            return AminoAcids.getState(code);
        }

        public State getState(char code) {
            return AminoAcids.getState(code);
        }

        public int getCodeLength() {
            return 1;
        }

        public State getState(int index) {
            return AminoAcids.getState(index);
        }

        public State getUnknownState() {
            return AminoAcids.getUnknownState();
        }

        public State getGapState() {
            return AminoAcids.getGapState();
        }

        public boolean isUnknown(State state) {
            return AminoAcids.isUnknown((AminoAcidState) state);
        }

        public boolean isGap(State state) {
            return AminoAcids.isGap((AminoAcidState) state);
        }

        public String getName() {
            return AminoAcids.NAME;
        }

        public String getNexusDataType() {
            return "protein";
        }

        public State[] toStateArray(String sequenceString) {
            return AminoAcids.toStateArray(sequenceString);
        }

        public State[] toStateArray(byte[] indexArray) {
            return AminoAcids.toStateArray(indexArray);
        }

        public String toString() {
            return getName();
        }
    };

    public static final SequenceType CODON = new SequenceType() {
        public int getStateCount() {
            return Codons.getStateCount();
        }

        public List<State> getStates() {
            return Codons.getStates();
        }

        public int getCanonicalStateCount() {
            return Codons.getCanonicalStateCount();
        }

        public List<State> getCanonicalStates() {
            return Codons.getCanonicalStates();
        }

        public State getState(String code) {
            return Codons.getState(code);
        }

        public State getState(char code) {
            // if anybody searches for a string of length one he should get a null from getState(String) anyway
            return null;
        }

        public int getCodeLength() {
            return 3;
        }

        public State getState(int index) {
            return Codons.getState(index);
        }

        public State getUnknownState() {
            return Codons.getUnknownState();
        }

        public State getGapState() {
            return Codons.getGapState();
        }

        public boolean isUnknown(State state) {
            return Codons.isUnknown((CodonState) state);
        }

        public boolean isGap(State state) {
            return Codons.isGap((CodonState) state);
        }

        public String getName() {
            return Codons.NAME;
        }

        public String getNexusDataType() {
            return "dna";
        } // Guessing here (JH)

        public State[] toStateArray(String sequenceString) {
            return Codons.toStateArray(sequenceString);
        }

        public State[] toStateArray(byte[] indexArray) {
            return Codons.toStateArray(indexArray);
        }

        public String toString() {
            return getName();
        }
    };

    public static final SequenceType BINARY = new SequenceType() {

        @Override
        public int getStateCount() {
            return Binary.getStateCount();
        }

        @Override
        public List<? extends State> getStates() {
            return Binary.getStates();
        }

        @Override
        public int getCanonicalStateCount() {
            return Binary.getCanonicalStateCount();
        }

        @Override
        public List<? extends State> getCanonicalStates() {
            return Binary.getCanonicalStates();
        }

        @Override
        public State getState(String code) {
            return Binary.getState(code);
        }

        @Override
        public State getState(char code) {
            return Binary.getState(code);
        }

        @Override
        public int getCodeLength() {
            return 1;
        }

        @Override
        public State getState(int index) {
            return Binary.getState(index);
        }

        @Override
        public State getUnknownState() {
            return Binary.getUnknownState();
        }

        @Override
        public State getGapState() {
            return Binary.getGapState();
        }

        @Override
        public boolean isUnknown(State state) {
            return Binary.isUnknown(state);
        }

        @Override
        public boolean isGap(State state) {
            return Binary.isGap(state);
        }

        @Override
        public String getName() {
            return Binary.NAME;
        }

        @Override
        public String getNexusDataType() {
            return Binary.NAME;
        }

        @Override
        public State[] toStateArray(String sequenceString) {
            return Binary.toStateArray(sequenceString);
        }

        @Override
        public State[] toStateArray(byte[] indexArray) {
            return Binary.toStateArray(indexArray);
        }
    };


    public class Utils {
        private Utils() { }  // make class uninstantiable

        public static String getAlphabet(SequenceType sequenceType) {

            StringBuilder buffer = new StringBuilder();
            for (State state : sequenceType.getCanonicalStates()) {
                buffer.append(state.getCode());
            }
            return buffer.toString();
        }

        /**
         * @param dataTypeName  keywords in Nexus or data type descriptions
         */
        public static SequenceType getDataType(String dataTypeName) {
            // remove spaces, all lower case
            switch (dataTypeName.trim().toLowerCase()) {
                // keywords in Nexus DATATYPE
                case "rna":
                case "dna":
                case "nucleotide":
                    return NUCLEOTIDE;
                case "aminoacid":
                case "protein":
                    return AMINO_ACID;
                case "binary":
                    return BINARY;
//                case "standard":
//                case "continuous":
//                    return STANDARD; // TODO parse continuous DATATYPE in NexusImporter
                default:
                    throw new UnsupportedOperationException(dataTypeName);
            }
        }
    }
}
