import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ManagementKas extends JFrame {
    private JTextField txtNama;
    private JTextField txtJumlah;
    private JButton btnTambah;
    private JButton btnEdit;
    private JButton btnHapus;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1; // Menyimpan indeks baris yang dipilih

    public ManagementKas() {
        setTitle("Management Kas Kelas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel untuk input data
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridBagLayout());
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan TextField untuk Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(new JLabel("Nama:"), gbc);

        txtNama = new JTextField(20);
        gbc.gridx = 1;
        panelInput.add(txtNama, gbc);

        /**
         * bayu
         */

        // Label dan TextField untuk Jumlah
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelInput.add(new JLabel("Jumlah:"), gbc);

        txtJumlah = new JTextField(20);
        gbc.gridx = 1;
        panelInput.add(txtJumlah, gbc);

        // Panel untuk tombol
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");

        panelButtons.add(btnTambah);
        panelButtons.add(btnEdit);
        panelButtons.add(btnHapus);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panelInput.add(panelButtons, gbc);
        add(panelInput, BorderLayout.NORTH);

        /**
         * wahyu
         */

        // Tabel untuk menampilkan data
        tableModel = new DefaultTableModel(new String[]{"Nama", "Jumlah (Rupiah)", "Tanggal"}, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Data Kas"));

        add(scrollPane, BorderLayout.CENTER);

        // Action listener untuk tombol tambah
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = txtNama.getText().trim();
                    String jumlahText = txtJumlah.getText().trim();

                    // Validasi input
                    if (nama.isEmpty() || jumlahText.isEmpty()) {
                        throw new IllegalArgumentException("Input tidak boleh kosong!");
                    }

                    double jumlah = Double.parseDouble(jumlahText);
                    String jumlahFormatted = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(jumlah);

                    // Menambahkan data ke tabel dengan tanggal saat ini
                    String tanggal = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    tableModel.addRow(new Object[]{nama, jumlahFormatted, tanggal});
                    clearInputFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

/**
 * Bayu
 */

        // Action listener untuk tombol edit
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectedRow = table.getSelectedRow();
                    if (selectedRow == -1) {
                        throw new IllegalStateException("Silakan pilih baris untuk diedit!");
                    }

                    String nama = txtNama.getText().trim();
                    String jumlahText = txtJumlah.getText().trim();

                    // Validasi input
                    if (nama.isEmpty() || jumlahText.isEmpty()) {
                        throw new IllegalArgumentException("Input tidak boleh kosong!");
                    }

                    double jumlah = Double.parseDouble(jumlahText);
                    String jumlahFormatted = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(jumlah);

                    // Mengedit data di tabel, tetapi tidak mengubah tanggal
                    tableModel.setValueAt(nama, selectedRow, 0);
                    tableModel.setValueAt(jumlahFormatted, selectedRow, 1);
                    clearInputFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException | IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener untuk tombol hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectedRow = table.getSelectedRow();
                    if (selectedRow == -1) {
                        throw new IllegalStateException("Silakan pilih baris untuk dihapus!");
                    }

                    tableModel.removeRow(selectedRow);
                    clearInputFields();
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Wahyu
         */

        // Listener untuk memilih baris di tabel
        table.getSelectionModel().addListSelectionListener(event -> {
            try {
                selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    txtNama.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    String jumlahFormatted = tableModel.getValueAt(selectedRow, 1).toString();
                    double jumlah = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).parse(jumlahFormatted).doubleValue();
                    txtJumlah.setText(String.valueOf(jumlah));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memilih baris: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void clearInputFields() {
        txtNama.setText("");
        txtJumlah.setText("");
        selectedRow = -1; // Reset selected row
        table.clearSelection(); // Clear selection in the table
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManagementKas managementKas = new ManagementKas();
            managementKas.setVisible(true);
        });
    }
}
