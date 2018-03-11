class CreateCourses < ActiveRecord::Migration[5.1]
  def change
    create_table :courses do |t|
      t.integer :code
      t.string :name
      t.integer :credits

      t.timestamps
    end
  end
end
